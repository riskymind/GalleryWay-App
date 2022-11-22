package com.asterisk.gallerywayapp.ui.gallery

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import com.asterisk.gallerywayapp.data.repository.GalleryRepositoryImpl
import com.asterisk.gallerywayapp.domain.use_cases.GetSearchResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val getSearchResult: GetSearchResult
) : ViewModel() {
    companion object {
        private const val DEFAULT_QUERY = "babies"
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private var currentQuery = MutableStateFlow(DEFAULT_QUERY)

    @OptIn(ExperimentalCoroutinesApi::class)
    val photos = currentQuery.flatMapLatest { queryString ->
        getSearchResult(queryString)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun searchQuery(query: String) {
        currentQuery.value = query
    }

}