package com.asterisk.gallerywayapp.data.remote.dto

import com.asterisk.gallerywayapp.domain.model.Result
import com.google.gson.annotations.SerializedName

data class ResultDTO(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("urls")
    val urls: UrlsDTO,
    @SerializedName("user")
    val user: UserDTO,
)

fun ResultDTO.toResult(): Result {
    return Result(
        id = id,
        likes = likes,
        urls = urls.toUrls(),
        user = user.toUser()
    )
}