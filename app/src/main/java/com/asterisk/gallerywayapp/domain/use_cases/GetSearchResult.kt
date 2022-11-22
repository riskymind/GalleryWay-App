package com.asterisk.gallerywayapp.domain.use_cases

import androidx.lifecycle.asFlow
import androidx.paging.PagingData
import com.asterisk.gallerywayapp.domain.repository.GalleryRepository
import javax.inject.Inject
import com.asterisk.gallerywayapp.domain.model.Result
import kotlinx.coroutines.flow.Flow

class GetSearchResult @Inject constructor(
    private val galleryRepository: GalleryRepository
) {

    operator fun invoke(query: String): Flow<PagingData<Result>> {
        return galleryRepository.getSearchResult(query)
    }
}