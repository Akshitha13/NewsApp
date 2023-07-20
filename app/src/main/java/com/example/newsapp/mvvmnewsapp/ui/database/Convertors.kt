package com.example.newsapp.mvvmnewsapp.ui.database

import androidx.room.TypeConverter
import com.example.newsapp.mvvmnewsapp.ui.models.Source

class Convertors {

    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }
    @TypeConverter
    fun toSource(name:String):Source{
        return Source(name,name)
    }
}