package com.asterisk.gallerywayapp.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    val id: String,
    val likes: Int,
    val urls: Urls,
    val user: User,
) : Parcelable
