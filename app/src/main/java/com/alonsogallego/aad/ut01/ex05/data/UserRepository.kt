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
        val users = remoteSource.getUsers()
        localSource.saveUsers(users)
    }

    fun getUserById(userId: Int) : User {
        //TODO: verificar en local sino en remote
    }

    fun removeUser(userId: Int){
        //TODO (local)
    }

}