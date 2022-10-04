package com.alonsogallego.aad.ut01.ex04

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.alonsogallego.aad.ut01.ex03.domain.News
import com.google.gson.Gson

class SecureSharedPreferences(val applicationContext: Context) {

    val gson = Gson()
    val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
    val mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

    val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
        "NAME_FILE",
        mainKeyAlias,
        applicationContext,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveNews(news: News) {
        val editor = sharedPreferences.edit()
        editor.putString(news.id.toString(), gson.toJson(news))
        editor.apply()
    }


}