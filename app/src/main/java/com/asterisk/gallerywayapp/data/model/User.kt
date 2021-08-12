package com.asterisk.gallerywayapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
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
) : Parcelable {
    val attributionUrl get() = "https://unsplash.com/$username?utm_source=GalleryWay&utm_medium=referral"
}