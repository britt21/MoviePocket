package com.example.moviepocket.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.moviepocket.MovieAdapter
import com.example.moviepocket.MovieViewModel
import com.example.moviepocket.databinding.FragmentMovieBinding

class MovieFragment() : Fragment() {

    lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater)

        val viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)


        binding.rvList.adapter = MovieAdapter()


        return  binding.root

    }



    companion object instance{
         fun instance(){
             MovieFragment
         }
    }
}