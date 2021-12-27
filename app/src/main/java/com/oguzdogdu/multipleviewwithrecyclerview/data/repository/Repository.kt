package com.oguzdogdu.multipleviewwithrecyclerview.data.repository

import com.oguzdogdu.multipleviewwithrecyclerview.data.network.Api
import com.oguzdogdu.multipleviewwithrecyclerview.data.network.SafeApiCall
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: Api
) : SafeApiCall {
    suspend fun getMovies() = safeApiCall { api.getMovies() }
    suspend fun getDirectors() = safeApiCall { api.getDirectors() }
}