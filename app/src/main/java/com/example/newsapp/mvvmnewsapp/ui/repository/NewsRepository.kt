package com.example.newsapp.mvvmnewsapp.ui.repository

import com.example.newsapp.mvvmnewsapp.ui.api.RetrofitInstance
import com.example.newsapp.mvvmnewsapp.ui.database.ArticleDatabase
import com.example.newsapp.mvvmnewsapp.ui.models.Article
import com.example.newsapp.mvvmnewsapp.ui.util.Constants.Companion.API_KEY

class NewsRepository( // get data from DB,API
    val db: ArticleDatabase
){
    suspend fun getBreakingNews(countryCode: String,pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber,API_KEY)
    
    suspend fun searchNews(searchQuery:String,pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber,API_KEY)

    suspend fun upsert(article: Article) = db.getArticleDAO().upsert(article)

    fun getSavedNews() = db.getArticleDAO().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDAO().deleteArticle(article)
}