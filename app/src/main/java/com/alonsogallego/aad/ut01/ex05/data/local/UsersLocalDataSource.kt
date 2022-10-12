package com.alonsogallego.aad.ut01.ex05.data.local

import android.content.SharedPreferences
import com.alonsogallego.aad.ut01.ex03.domain.News
import com.alonsogallego.aad.ut01.ex05.domain.User
import com.google.gson.Gson

class UsersLocalDataSource(val sharedPref: SharedPreferences) {

    private val gson = Gson()

    fun saveUsers(users: List<User>) {
        users.forEach {
            saveUser(it)
        }
    }

    fun saveUser(user: User) {
        val jsonUser: String = gson.toJson(user, User::class.java)
        val edit = sharedPref.edit()
        edit.putString(user.id.toString(), jsonUser)
        edit.apply() //guarda de forma asíncrona
    }

    fun getUsers(): List<User> {
        val userList = mutableListOf<User>()
        sharedPref.all.forEach { entry ->
            val user = gson.fromJson(entry.value as String, User::class.java)
            userList.add(user)
        }
        return userList
    }

    fun findById(userId: Int): User? {
        val jsonUser: String? = sharedPref.getString(userId.toString(), "null")
        return jsonUser?.let {
            gson.fromJson(it, User::class.java)
        }
    }

    fun remove(userId: Int){
        val edit = sharedPref.edit()
        edit.remove(userId.toString())
        edit.apply()
    }
}