package com.asterisk.gallerywayapp.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.asterisk.gallerywayapp.domain.model.Result
import kotlinx.coroutines.flow.Flow

interface GalleryRepository {

    fun getSearchResult(query: String): Flow<PagingData<Result>>
}