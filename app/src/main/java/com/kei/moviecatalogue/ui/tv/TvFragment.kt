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
import com.kei.moviecatalogue.model.tv.TvPopularItemResponse
import kotlinx.android.synthetic.main.fragment_movie.*

class TvFragment : Fragment() {
    private lateinit var popularTvAdapter: PopularTvAdapter
    private lateinit var tvViewModel: TvViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_tv, container, false)
        tvViewModel =
            ViewModelProvider(this).get(TvViewModel::class.java)

        tvViewModel.init(1)
        tvViewModel.getTvPopularData().observe(viewLifecycleOwner, Observer { tvPopular -> getInitTvPopular(tvPopular)})
        return root
    }

    private fun getInitTvPopular(tvPopular: List<TvPopularItemResponse>) {
        rv_popular_tv.apply {
            layoutManager =  LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            popularTvAdapter = PopularTvAdapter(tvPopular)
            rv_popular_tv.adapter = popularTvAdapter
        }
    }
}