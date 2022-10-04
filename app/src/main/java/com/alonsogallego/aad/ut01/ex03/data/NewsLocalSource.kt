package com.alonsogallego.aad.ut01.ex03.data

import android.content.SharedPreferences
import com.alonsogallego.aad.ut01.ex03.domain.News
import com.alonsogallego.aad.ut01.ex04.SecureSharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class NewsLocalSource (private val sharedPref: SharedPreferences) {

    private val gson = Gson()

    fun setNews(news: News) {

        val jsonNews = gson.toJson(news, News::class.java)

        val edit = sharedPref.edit()
        edit.putString(news.id.toString(), jsonNews)
        edit.apply() // asíncrono
    }

    fun findById(newsId:Int): News{
        val gson = Gson()

        val jsonNews = sharedPref.getString(newsId.toString(), "")

        return gson.fromJson<News>(jsonNews, News::class.java)
    }

    fun setNewsList(newsList: MutableList<News>){
        newsList.forEach{
            setNews(it)
        }
    }

    fun setNewsListV2(newsList: MutableList<News>) {
        val jsonNews = sharedPref.getString("ALL", "")

    }

    fun findAll() : MutableList<News>{
        val newsList = mutableListOf<News>()
        sharedPref.all.forEach { entry ->
            val news = gson.fromJson(entry.value as String, News::class.java)
            newsList.add(news)
        }
        return newsList
    }

    fun findALLV2(): MutableList<News> {
        val jsonNews = sharedPref.getString("ALL","")

        val typeNews: Type = object : TypeToken<MutableList<News>>() {}.type
        return gson.fromJson(jsonNews, typeNews)
    }

    fun findAllKotlin(): MutableList<News> {
        return sharedPref.all.map { entry ->
            gson.fromJson(entry.value as String, News::class.java)
        }.toMutableList()
    }

    private fun secure() {
        val secure = SecureSharedPreferences(applicationContext)
        secure.saveNews(News(1, "News1", "News1", "News1"))
    }
}