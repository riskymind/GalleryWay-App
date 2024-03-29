package com.asterisk.gallerywayapp.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.asterisk.gallerywayapp.data.remote.UnSplashApi
import com.asterisk.gallerywayapp.data.remote.dto.toResult
import retrofit2.HttpException
import java.io.IOException
import com.asterisk.gallerywayapp.domain.model.Result

private const val UNSPLASH_STARTING_PAGE_INDEX = 1

class UnSplashPagingSource(
    private val unSplashApi: UnSplashApi,
    private val query: String
) : PagingSource<Int, Result>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val position = params.key ?: UNSPLASH_STARTING_PAGE_INDEX
        return try {
            val response = unSplashApi.searchPhotos(query, position, params.loadSize)
            val photos = response.results.map { it.toResult() }

            LoadResult.Page(
                data = photos,
                prevKey = if (position == UNSPLASH_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        TODO("Not yet implemented")
    }
}