package com.kei.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kei.moviecatalogue.R
import com.kei.moviecatalogue.adapter.PopularMovieAdapter
import com.kei.moviecatalogue.adapter.UpcomingMovieAdapter
import com.kei.moviecatalogue.model.movie.MovieItemResponse
import com.kei.moviecatalogue.model.movie.UpcomingResponse
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var popularMovieAdapter: PopularMovieAdapter
    private lateinit var upcomingMovieAdapter: UpcomingMovieAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_movie, container, false)
        movieViewModel =
                ViewModelProvider(this).get(MovieViewModel::class.java)

        //popular
        movieViewModel.init(1)
        movieViewModel.getData().observe(viewLifecycleOwner, Observer { popularMovie -> getInitPopular(popularMovie)})

        //upcoming
        movieViewModel.initUp(1)
        movieViewModel.getDataUpcoming().observe(viewLifecycleOwner, Observer { movieUpcoming -> getInitUpcoming(movieUpcoming)})

        return root
    }

    private fun getInitUpcoming(movieUpcoming: List<UpcomingResponse>) {
        rv_upcoming_movie.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
            upcomingMovieAdapter = UpcomingMovieAdapter(movieUpcoming)
            rv_upcoming_movie.adapter = upcomingMovieAdapter
        }
    }

    private fun getInitPopular(popularMovie: List<MovieItemResponse>) {
        //live data = asyncronus method
        rv_popular_movie.apply {
            layoutManager =  LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            popularMovieAdapter = PopularMovieAdapter(popularMovie)
            rv_popular_movie.adapter = popularMovieAdapter
        }
    }
}