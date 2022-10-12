package com.alonsogallego.aad.ut01.ex05.data

import com.alonsogallego.aad.ut01.ex05.data.local.UsersLocalDataSource
import com.alonsogallego.aad.ut01.ex05.data.remote.UsersRemoteDataSource
import com.alonsogallego.aad.ut01.ex05.domain.User

class UserRepository (
    val localSource: UsersLocalDataSource,
    val remoteSource: UsersRemoteDataSource
) {

    /**
     * First from local and then from remote
     */
    fun getUsers(): List<User> {
        var users = localSource.getUsers()
        if (users.isEmpty()) {
            users = remoteSource.getUsers()
            localSource.saveUsers(users)
        }
        return users
    }

    fun getUserById(userId: Int) : User {
        var user = localSource.findById(userId)
        if (user == null) {
            user = remoteSource.getUser(userId)
        }
        return user
    }

    fun removeUser(userId: Int){
        localSource.remove(userId)
    }

}