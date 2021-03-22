package com.example.neogamescollectionapp.services.mockedapis

import com.example.neogamescollectionapp.services.model.User

class MockedUsers {

    companion object{
        val instance = MockedUsers()
    }

    var users = ArrayList<User>()

    init {
        users.add(User("Gui", "123", "g.mergullion@outlook.com"))
    }

}