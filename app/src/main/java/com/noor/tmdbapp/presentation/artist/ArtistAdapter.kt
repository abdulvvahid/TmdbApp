package com.noor.tmdbapp.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.noor.tmdbapp.R
import com.noor.tmdbapp.data.model.artist.Artist
import com.noor.tmdbapp.databinding.ArtistItemBinding

class ArtistAdapter(): RecyclerView.Adapter<MyViewHolder>() {

    private val artistList = ArrayList<Artist>()

    fun setList(artists: List<Artist>){
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ArtistItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.artist_item,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int = artistList.size

}

class MyViewHolder(
    val binding: ArtistItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(artist: Artist) {
        binding.actorItemTitleTextView.text = artist.name
        val posterUrl: String = "https://image.tmdb.org/t/p/w500" + artist.profilePath
        Glide.with(binding.actorItemImageView.context)
            .load(posterUrl)
            .into(binding.actorItemImageView)
    }

}