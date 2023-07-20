package com.example.newsapp.mvvmnewsapp.ui.models

import android.util.Log
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "articles"
)
data class Article(

    @PrimaryKey
    val id: Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : Serializable {
    // app crashes while trying to load a URL to the webview client in a fragment from a data class.
    // helps below code to check for null or empty
    override fun hashCode(): Int {
        var result = id.hashCode()
        Log.d("Akshitha", "hashCode: $result")
        if(url?.isEmpty() == true){
            result = 31 * result + url.hashCode()
        }
        return result
    }
}