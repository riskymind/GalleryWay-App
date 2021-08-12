package com.asterisk.gallerywayapp.ui.gallery

import androidx.lifecycle.ViewModel
import com.asterisk.gallerywayapp.data.repository.GalleryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val repository: GalleryRepository
): ViewModel() {

}