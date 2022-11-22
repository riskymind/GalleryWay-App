package com.asterisk.gallerywayapp.data.remote.dto

import com.asterisk.gallerywayapp.domain.model.User
import com.google.gson.annotations.SerializedName


data class UserDTO(
    @SerializedName("first_name")
    val first_name: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("last_name")
    val last_name: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String
)

fun UserDTO.toUser(): User {
    return User(
        id = id,
        username = username
    )
}