package com.alonsogallego.aad.ut01.ex07.data.local

import android.content.SharedPreferences
import com.alonsogallego.aad.ut01.ex07.domain.User
import com.google.gson.Gson

class UsersLocalDataSource (val sharedPref: SharedPreferences) {

    private val gson = Gson()

    fun getUsers(): List<User> {
        val userList = mutableListOf<User>()
        sharedPref.all.forEach {
            val user = gson.fromJson(it.value as String, User::class.java)
            userList.add(user)
        }
        return userList
    }

    fun saveUsers(users: List<User>) {
        users.forEach {
            saveUser(it)
        }
    }

    fun saveUser(user: User) {
        val jsonUser = gson.toJson(user, User::class.java)
        val edit = sharedPref.edit()
        edit.putString(user.id.toString(), jsonUser)
        edit.apply()
    }

    fun findById(userId: Int): User? {
        val jsonUser = sharedPref.getString(userId.toString(), "null")
        return jsonUser?.let {
            gson.fromJson(it, User::class.java)
        }
    }

    fun removeUser(userId: Int) {
        val edit = sharedPref.edit()
        val jsonUser = sharedPref.getString(userId.toString(), "null")
        edit.remove(jsonUser)
        edit.apply()
    }



}