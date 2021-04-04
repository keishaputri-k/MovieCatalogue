package com.kei.moviecatalogue.model.tv

import com.google.gson.annotations.SerializedName

data class TvTopRatedResponse(
	@SerializedName("page")
	val page: Int? = null,
	@SerializedName("results")
	val results: List<TvTopRatedItemResponse?>? = null
)


