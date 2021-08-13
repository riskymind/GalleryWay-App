package com.asterisk.gallerywayapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.asterisk.gallerywayapp.data.UnSplashPagingSource
import com.asterisk.gallerywayapp.data.api.UnSplashApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GalleryRepository @Inject constructor(
    private val unSplashApi: UnSplashApi
) {
    fun getSearchResult(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),

            pagingSourceFactory = {UnSplashPagingSource(unSplashApi, query)}
        ).liveData
}