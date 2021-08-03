package com.noor.tmdbapp.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.noor.tmdbapp.R
import com.noor.tmdbapp.data.model.tvshow.TvShow
import com.noor.tmdbapp.databinding.ListItemBinding

class TvShowAdapter(): RecyclerView.Adapter<MyViewHolder>() {

    private val tvShowList = ArrayList<TvShow>()

    fun setList(tvShows: List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShows)
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
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int = tvShowList.size

}

class MyViewHolder(
    val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(tvShow: TvShow){
        binding.listItemTitleTextView.text = tvShow.name
        binding.listItemAverageVote.text = tvShow.voteAverage.toString()
        binding.listItemReleaseDate.text = tvShow.firstAirDate
        val posterUrl: String = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
        Glide.with(binding.listItemImageView.context)
            .load(posterUrl)
            .into(binding.listItemImageView)
    }

}