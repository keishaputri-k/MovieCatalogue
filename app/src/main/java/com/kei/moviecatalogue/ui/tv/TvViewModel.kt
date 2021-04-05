package com.kei.moviecatalogue.ui.tv

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kei.moviecatalogue.BuildConfig
import com.kei.moviecatalogue.model.tv.TvPopularItemResponse
import com.kei.moviecatalogue.model.tv.TvPopularResponse
import com.kei.moviecatalogue.model.tv.TvTopRatedItemResponse
import com.kei.moviecatalogue.model.tv.TvTopRatedResponse
import com.kei.moviecatalogue.network.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvViewModel : ViewModel() {
    fun init(page : Int){
        getPopularTV(page)
    }
    private val dataPopularTv = MutableLiveData<List<TvPopularItemResponse>>()
    private fun getPopularTV(page: Int) {
        RetrofitConfig().getApiService().getTvPopular(BuildConfig.API_KEY, page).enqueue(object : Callback<TvPopularResponse> {
            override fun onResponse(call: Call<TvPopularResponse>, response: Response<TvPopularResponse>) {
                if (response.isSuccessful){
                    val responseTvPopular : TvPopularResponse? = response.body()
                    dataPopularTv.postValue(responseTvPopular?.result)
                }
            }

            override fun onFailure(call: Call<TvPopularResponse>, t: Throwable) {
                Log.e("Failure", t.toString())
            }
        })
    }
    fun getTvPopularData() : LiveData<List<TvPopularItemResponse>> {
        return dataPopularTv
    }
    /*======================================================Top Rated Tv============================================================== */
    fun initTop (page: Int){
        getTopRated(page)
    }
    private val dataTopRated= MutableLiveData<ArrayList<TvTopRatedItemResponse>>()
    private fun getTopRated(page: Int){
        RetrofitConfig().getApiService().getTvTopRated(BuildConfig.API_KEY, page).enqueue(object : Callback<TvTopRatedResponse>{
            override fun onResponse(call: Call<TvTopRatedResponse>, response: Response<TvTopRatedResponse>) {
                if (response.isSuccessful){
                    val topRatedResponse : TvTopRatedResponse? = response.body()
                    dataTopRated.postValue(topRatedResponse?.results)
                }
            }
            override fun onFailure(call: Call<TvTopRatedResponse>, t: Throwable) {
                Log.e("Failure", t.toString())
            }
        })
    }
    fun getDataTopRated(): MutableLiveData<ArrayList<TvTopRatedItemResponse>> {
        return dataTopRated
    }
}


