package com.example.movies

import com.example.movies.Models.movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("3/trending/movie/day?api_key=cb213741fa9662c69add38c5a59c0110")
    suspend fun getMoviesData(): Response<movies>
}
