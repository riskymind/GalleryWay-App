package com.asterisk.gallerywayapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class UnSplashPhotoDTO(
    @SerializedName("results")
    val results: List<ResultDTO>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val total_pages: Int
)