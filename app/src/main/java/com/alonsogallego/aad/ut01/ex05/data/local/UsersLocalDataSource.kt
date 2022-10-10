package com.alonsogallego.aad.ut01.ex05.data.local

import com.alonsogallego.aad.ut01.ex05.domain.User

class UsersLocalDataSource {

    fun saveUsers(users: List<User>) {
        //TODO
    }

    fun getUsers(): List<User>? {
        //TODO
        return emptyList()
    }

    fun findById(userId: Int): User {
        //TODO return a user
    }

    fun remove(userId: Int){
        //TODO
    }
}