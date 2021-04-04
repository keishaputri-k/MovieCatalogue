package com.kei.moviecatalogue.model.tv

import com.google.gson.annotations.SerializedName

data class TvTopRatedItemResponse(
        @field:SerializedName("overview")
        val overview: String? = null,

        @field:SerializedName("original_language")
        val originalLanguage: String? = null,

        @field:SerializedName("poster_path")
        val posterPath: String? = null,

        @field:SerializedName("popularity")
        val popularity: Double? = null,

        @field:SerializedName("name")
        val name: String? = null
)