package com.asterisk.gallerywayapp.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.asterisk.gallerywayapp.data.paging_source.UnSplashPagingSource
import com.asterisk.gallerywayapp.data.remote.UnSplashApi
import com.asterisk.gallerywayapp.domain.repository.GalleryRepository
import javax.inject.Inject
import javax.inject.Singleton
import com.asterisk.gallerywayapp.domain.model.Result
import kotlinx.coroutines.flow.Flow

class GalleryRepositoryImpl @Inject constructor(
    private val unSplashApi: UnSplashApi
) : GalleryRepository {
    override fun getSearchResult(query: String): Flow<PagingData<Result>> =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnSplashPagingSource(unSplashApi, query) }
        ).flow
}