package com.example.movies

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.Models.Result
import com.example.movies.Models.movies
import com.example.movies.databinding.MoviesitemviewBinding

class MoviesAdapters(val context : Context, val itemList: List<Result>) : RecyclerView.Adapter<MoviesAdapters.MyViewHolder>() {



    inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var binding = MoviesitemviewBinding.bind(view)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(context).inflate(R.layout.moviesitemview,parent,false))
    }

    override fun getItemCount(): Int {
      return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val listpos = itemList[position]

        Glide.with(context).
        load("https://image.tmdb.org/t/p/w1280/${listpos.poster_path}")
            .into(holder.binding.poster)
        Log.d("SHUBH", "getMovies: https://image.tmdb.org/t/p/w1280/${listpos.poster_path}.jpg")
        holder.binding.realeaseDate.text = " Release - ${listpos.release_date}"
        holder.binding.title.text = listpos.original_title
        holder.binding.Lang.text = listpos.original_language
        holder.binding.totalVote.text =  "Vote - ${listpos.vote_count.toString()}"
        holder.binding.discriptions.text = listpos.overview
    }

}