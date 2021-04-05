package com.kei.moviecatalogue.model.tv

import com.google.gson.annotations.SerializedName

data class TvTopRatedResponse(
	@SerializedName("page")
	val page: Int,
	@SerializedName("results")
	val results: ArrayList<TvTopRatedItemResponse>
)


