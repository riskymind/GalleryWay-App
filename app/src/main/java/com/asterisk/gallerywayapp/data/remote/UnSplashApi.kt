package com.asterisk.gallerywayapp.data.remote

import com.asterisk.gallerywayapp.commons.Constants.CLIENT_ID
import com.asterisk.gallerywayapp.data.remote.dto.UnSplashPhotoDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnSplashApi {


    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): UnSplashPhotoDTO
}