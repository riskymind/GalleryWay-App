package com.asterisk.gallerywayapp.data.repository

import com.asterisk.gallerywayapp.data.api.UnSplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GalleryRepository @Inject constructor(
    private val unSplashApi: UnSplashApi
) {

}