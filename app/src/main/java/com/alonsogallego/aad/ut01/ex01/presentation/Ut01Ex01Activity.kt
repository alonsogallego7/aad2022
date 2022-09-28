package com.alonsogallego.aad.ut01.ex01.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.alonsogallego.aad.R
import com.alonsogallego.aad.ut01.ex01.data.PreferenceLocalSource
import com.alonsogallego.aad.ut01.ex01.data.SharedPreferenceLocalSource
import com.alonsogallego.aad.ut01.ex01.domain.Customer

class Ut01Ex01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)

        initSharedPreferences()
        initPreferences()
    }

    private fun initSharedPreferences() {
        //val spCustomer: SharedPreferenceLocalSource = SharedPreferenceSource(this)
        val spCustomer = SharedPreferenceLocalSource(this)
        spCustomer.saveCustomer(Customer(2, "Customer2", "Surname1", true))

        ContextCompat.getColor(this, R.color.black)
        application.cont

        val newCustomer = spCustomer.getCustomer()
        Log.d("@dev", "Customer $newCustomer")
    }

    private fun initPreferences() {
        //val spCustomer: SharedPreferenceLocalSource = SharedPreferenceSource(this)
        val spCustomer = PreferenceLocalSource(this)
        spCustomer.saveCustomer(Customer(1, "Customer1", "Surname1", true))

        val newCustomer = spCustomer.getCustomer()
        Log.d("@dev", "Customer $newCustomer")
    }

}