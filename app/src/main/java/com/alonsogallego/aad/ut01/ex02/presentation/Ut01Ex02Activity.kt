package com.alonsogallego.aad.ut01.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alonsogallego.aad.R
import com.alonsogallego.aad.ut01.ex02.data.AppLocalSource
import com.alonsogallego.aad.ut01.ex02.domain.App

class Ut01Ex02Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex02)

        initAppAssistant()
    }

    private fun initAppAssistant() {
        val localSource = AppLocalSource(this)
        showAppInfo(localSource.getApp())
        localSource.saveApp(App(false))
    }

    private fun showAppInfo(app: App) {
        if (app.isFirstOpened){
            Log.d("@dev", "Si, es la primera vez que se abre la app?:${app.isFirstOpened}")
        } else {
            Log.d("@dev", "No, no es la primera vez que se abre la app?:${app.isFirstOpened}")

        }
    }
}