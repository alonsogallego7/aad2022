package com.alonsogallego.aad.ut01.ex05.data.remote

import com.alonsogallego.aad.ut01.ex05.domain.Address
import com.alonsogallego.aad.ut01.ex05.domain.Company
import com.alonsogallego.aad.ut01.ex05.domain.User

class UsersRemoteDataSource {

    /**
     * Mock
     * Replace with getUser from PSP
     */
    fun getUsers(): List<User>{
        return mutableListOf(
            User(1, "User1", "Username1", "Email1", Address("Street1", "Suite1", "City1", "Zipcode1", "Geo1"), "Phone1", "Website1", Company("Name1", "CatchPhrase1", "Bs1")),
            User(1, "User2", "Username2", "Email2", Address("Street2", "Suite2", "City2", "Zipcode2", "Geo2"), "Phone2", "Website2", Company("Name2", "CatchPhrase2", "Bs2")),
            User(1, "User3", "Username3", "Email3", Address("Street3", "Suite3", "City3", "Zipcode3", "Geo3"), "Phone3", "Website3", Company("Name3", "CatchPhrase3", "Bs3")),

        )
    }

    fun getUser(userId: Int) : User{
        return User(userId, "User$userId", "Username$userId", "Email$userId", Address("Street$userId", "Suite$userId", "City$userId", "Zipcode$userId", "Geo$userId"), "Phone$userId", "Website$userId", Company("Name$userId", "CatchPhrase$userId", "Bs$userId"))
    }

}