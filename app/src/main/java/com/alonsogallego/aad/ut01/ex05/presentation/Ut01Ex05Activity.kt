package com.alonsogallego.aad.ut01.ex05.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alonsogallego.aad.R
import com.alonsogallego.aad.ut01.ex05.data.UserRepository
import com.alonsogallego.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.alonsogallego.aad.ut01.ex05.data.remote.UsersRemoteDataSource

class Ut01Ex05Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex05)

        init()
    }

    private fun init(){
        //Obtain all users from data layer
        val userRepository = UserRepository(
            UsersLocalDataSource(this.getPreferences(MODE_PRIVATE)),
            UsersRemoteDataSource()
        )

        Log.d("@dev", "Users: ${userRepository.getUsers()}")
        Log.d("@dev", "User: ${userRepository.getUserById(1)}")
        userRepository.removeUser(1)
        Log.d("@dev", "User: ${userRepository.getUsers()}")


    }
}