package com.kei.moviecatalogue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kei.moviecatalogue.BuildConfig
import com.kei.moviecatalogue.R
import com.kei.moviecatalogue.model.tv.TvPopularItemResponse
import kotlinx.android.synthetic.main.item_popular_movie.view.*
import kotlinx.android.synthetic.main.item_tv_popular.view.*

class PopularTvAdapter(var listTvPopular : List<TvPopularItemResponse>) : RecyclerView.Adapter<PopularTvAdapter.TvPopularViewHolder>() {
     class TvPopularViewHolder ( view : View): RecyclerView.ViewHolder (view){
        fun bind (tvPopular :TvPopularItemResponse) {
            with(itemView) {
                Glide.with(context).load(BuildConfig.IMAGE_URL + tvPopular.poster_path).into(iv_tv_poster_popular)
                tv_title_tv_popular.text = tvPopular.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularTvAdapter.TvPopularViewHolder {
        return TvPopularViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_tv_popular, parent, false))

    }

    override fun getItemCount(): Int = listTvPopular.size

    override fun onBindViewHolder(holder: PopularTvAdapter.TvPopularViewHolder, position: Int) {
        holder.bind(listTvPopular.get(position))
    }

}