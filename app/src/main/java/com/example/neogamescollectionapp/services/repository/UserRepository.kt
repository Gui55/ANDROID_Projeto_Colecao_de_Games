package com.example.neogamescollectionapp.services.repository

import com.example.neogamescollectionapp.services.mockedapis.MockedUsers

class UserRepository {

    companion object{
        val instance = UserRepository()
    }

    fun userExists(user: String): Boolean {

        for(a in MockedUsers.instance.users){
            if(a.name == user) {
                return true
            }
        }

        return false

    }

    fun passwordCorrect(user: String, password: String): Boolean {

        for(a in MockedUsers.instance.users){
            if(a.name==user && a.password==password){
                return true
            }
        }

        return false
    }

}