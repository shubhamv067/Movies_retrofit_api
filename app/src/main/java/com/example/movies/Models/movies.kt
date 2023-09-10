package com.example.movies.Models

data class movies(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)