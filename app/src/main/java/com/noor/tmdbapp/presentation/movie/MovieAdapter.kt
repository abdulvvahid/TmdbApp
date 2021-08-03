package com.noor.tmdbapp.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.noor.tmdbapp.R
import com.noor.tmdbapp.data.model.movie.Movie
import com.noor.tmdbapp.databinding.ListItemBinding

class MovieAdapter: RecyclerView.Adapter<MyViewHolder>() {

    private val movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size
}


class MyViewHolder(val binding: ListItemBinding)
    : RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie){
            binding.listItemTitleTextView.text = movie.title
            binding.listItemReleaseDate.text = movie.releaseDate
            binding.listItemAverageVote.text = movie.voteAverage.toString()
            val posterUrl: String = "https://image.tmdb.org/t/p/w500"+movie.posterPath
            Glide.with(binding.listItemImageView.context)
                .load(posterUrl)
                .into(binding.listItemImageView)
        }

}