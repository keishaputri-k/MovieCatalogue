package com.kei.moviecatalogue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kei.moviecatalogue.BuildConfig
import com.kei.moviecatalogue.R
import com.kei.moviecatalogue.model.tv.TvTopRatedItemResponse
import kotlinx.android.synthetic.main.item_top_rated_tv.view.*


class TopRatedTvAdapter(var listTvTopRated : List<TvTopRatedItemResponse>) : RecyclerView.Adapter<TopRatedTvAdapter.TvTopRatedViewHolder>(){
    class TvTopRatedViewHolder ( view : View): RecyclerView.ViewHolder (view){
        fun bind (tvTopRated : TvTopRatedItemResponse){
            with(itemView){
                Glide.with(context).load(BuildConfig.IMAGE_URL + tvTopRated.posterPath).into(iv_top_rated)
                tv_title_top_rated.text = tvTopRated.name
                tv_description_top_rated.text = tvTopRated.overview
                tv_date_top_rated.text = tvTopRated.firstAirDate
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedTvAdapter.TvTopRatedViewHolder {
        return TvTopRatedViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_top_rated_tv, parent, false))
    }

    override fun getItemCount(): Int = listTvTopRated.size

    override fun onBindViewHolder(holder: TvTopRatedViewHolder, position: Int) {
        holder.bind(listTvTopRated.get(position))
    }

}