package com.asterisk.gallerywayapp.data.remote.dto

import com.asterisk.gallerywayapp.domain.model.Urls
import com.google.gson.annotations.SerializedName

data class UrlsDTO(
    @SerializedName("full")
    val full: String,
    @SerializedName("raw")
    val raw: String,
    @SerializedName("regular")
    val regular: String,
    @SerializedName("small")
    val small: String,
    @SerializedName("thumb")
    val thumb: String
)

fun UrlsDTO.toUrls(): Urls {
    return Urls(
        full = full,
        raw = raw,
        regular = regular,
        small = small,
        thumb = thumb
    )
}