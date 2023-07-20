package com.example.newsapp.mvvmnewsapp.ui.models

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)