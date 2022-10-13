package com.alonsogallego.aad.ut01.ex07.data

import com.alonsogallego.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.alonsogallego.aad.ut01.ex05.data.remote.UsersRemoteDataSource
import com.alonsogallego.aad.ut01.ex05.domain.User

class UserRepository (val localSource: UsersLocalDataSource){

    fun getUsers(): List<User> {
        var users = localSource.getUsers()
        return users
    }

    fun getUserById(userId: Int) : User? {
        var user = localSource.findById(userId)
        return user
    }

    fun removeUser(userId: Int){
        localSource.remove(userId)
    }

}