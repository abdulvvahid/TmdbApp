package com.noor.tmdbapp.presentation.movie

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.noor.tmdbapp.BuildConfig
import com.noor.tmdbapp.R
import com.noor.tmdbapp.data.model.movie.Movie
import com.noor.tmdbapp.databinding.FragmentMoviesBinding
import com.noor.tmdbapp.presentation.di.Injector
import com.noor.tmdbapp.presentation.di.core.AppModule
import com.noor.tmdbapp.presentation.di.core.DaggerAppComponent
import com.noor.tmdbapp.presentation.di.core.NetModule
import com.noor.tmdbapp.presentation.di.core.RemoteDataModule
import javax.inject.Inject

class MoviesFragment : Fragment() {

    @Inject
    lateinit var factory: MoviesViewModelFactory
    private lateinit var binding: FragmentMoviesBinding
    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_movies, container, false)
        // Inflate the layout for this fragment

        (activity?.applicationContext as Injector).createMovieSubComponent()
            .inject(this)
        activity?.title = "Trending Movies"

        moviesViewModel = ViewModelProvider(this,factory)
            .get(MoviesViewModel::class.java)

        initRecyclerView()

        binding.movieSwipeRefreshLayout.setOnRefreshListener {
            updateMovies()
            binding.movieSwipeRefreshLayout.isRefreshing = false
        }

        return binding.root
    }

    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL,false)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData: LiveData<List<Movie>?> = moviesViewModel.getMovies()
        responseLiveData.observe(viewLifecycleOwner, Observer{
            if(it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(context,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        return when(item.itemId){
//            R.id.action_update -> {
//                updateMovies()
//                true
//            }
//            else -> {
//                return super.onOptionsItemSelected(item)
//            }
//        }
//    }

    fun updateMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val response: LiveData<List<Movie>?> = moviesViewModel.updateMovies()
        response.observe(viewLifecycleOwner, Observer {
            if(it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
            }
        })
    }

}