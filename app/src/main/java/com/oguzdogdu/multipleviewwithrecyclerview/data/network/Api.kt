package com.oguzdogdu.multipleviewwithrecyclerview.data.network

import com.oguzdogdu.multipleviewwithrecyclerview.ui.HomeRecyclerViewItem
import retrofit2.http.GET

interface Api {

    @GET("movies")
    suspend fun getMovies(): List<HomeRecyclerViewItem.Movie>

    @GET("directors")
    suspend fun getDirectors(): List<HomeRecyclerViewItem.Director>
}