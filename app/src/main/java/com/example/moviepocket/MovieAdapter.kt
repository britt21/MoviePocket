package com.example.moviepocket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviepocket.databinding.ItemListBinding
import com.example.moviepocket.movies.Result
import kotlinx.android.synthetic.main.item_list.view.*

class MovieAdapter : ListAdapter<Result, MovieAdapter.MovieViewHolder>(DiffCallback) {
    class MovieViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Result){
            val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
            binding.movies = result
            Glide.with(itemView).load(IMAGE_BASE + result.poster_path).into(itemView.imageView)
            binding.executePendingBindings()

        }




    }
    companion object DiffCallback : DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return  MovieViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context)))

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movies = getItem(position)
        holder.bind(movies)


    }
}