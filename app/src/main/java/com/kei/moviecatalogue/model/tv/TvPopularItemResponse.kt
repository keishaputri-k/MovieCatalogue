package com.kei.moviecatalogue.model.tv

import com.google.gson.annotations.SerializedName

data class TvPopularItemResponse (
    @SerializedName("poster_path")
    val poster_path:String,
    @SerializedName("popularity")
    val popularity:Double,
    @SerializedName("name")
    val name:String
)