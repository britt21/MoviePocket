package com.example.moviepocket

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviepocket.movies.Result


@BindingAdapter("listofdata")
fun bindit(recyclerView: RecyclerView, data: List<Result>?){
    val adapter = recyclerView.adapter as MovieAdapter
    adapter.submitList(data)
}