package com.kei.moviecatalogue.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kei.moviecatalogue.R
import com.kei.moviecatalogue.adapter.PopularTvAdapter
import com.kei.moviecatalogue.adapter.TopRatedTvAdapter
import com.kei.moviecatalogue.model.tv.TvPopularItemResponse
import com.kei.moviecatalogue.model.tv.TvTopRatedItemResponse
import com.kei.moviecatalogue.model.tv.TvTopRatedResponse
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_tv.*

class TvFragment : Fragment() {
    private lateinit var popularTvAdapter: PopularTvAdapter
    private lateinit var tvViewModel: TvViewModel
    private lateinit var topRatedTvAdapter : TopRatedTvAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_tv, container, false)
        tvViewModel = ViewModelProvider(this).get(TvViewModel::class.java)
        //popular
        tvViewModel.init(1)
        tvViewModel.getTvPopularData().observe(viewLifecycleOwner, Observer { tvPopular -> getInitTvPopular(tvPopular)})
        //top rated
        tvViewModel.initTop(1)
        tvViewModel.getDataTopRated().observe(viewLifecycleOwner, Observer { tvTopRated -> getInitTvTopRated(tvTopRated) })
        return root
    }

    private fun getInitTvTopRated(tvTopRated: List<TvTopRatedItemResponse>) {
        rv_top_rated_tv.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
            topRatedTvAdapter = TopRatedTvAdapter(tvTopRated)
            rv_top_rated_tv.adapter = topRatedTvAdapter
        }
    }

    private fun getInitTvPopular(tvPopular: List<TvPopularItemResponse>) {
        rv_popular_tv.apply {
            layoutManager =  LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            popularTvAdapter = PopularTvAdapter(tvPopular)
            rv_popular_tv.adapter = popularTvAdapter
        }
    }
}