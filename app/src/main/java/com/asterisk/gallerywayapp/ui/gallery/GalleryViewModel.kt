package com.asterisk.gallerywayapp.ui.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.asterisk.gallerywayapp.data.repository.GalleryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: GalleryRepository
): ViewModel() {
    companion object {
        private const val DEFAULT_QUERY = "babies"
    }

    private var currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchResult(queryString)
    }

    fun searchQuery(query: String) {
        currentQuery.value = query
    }

}