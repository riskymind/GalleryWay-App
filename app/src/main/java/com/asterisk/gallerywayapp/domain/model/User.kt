package com.asterisk.gallerywayapp.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: String,
    val username: String
): Parcelable {
    val attributionUrl get() = "https://unsplash.com/$username?utm_source=GalleryWay&utm_medium=referral"
}
