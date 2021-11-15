package com.capgemini.springboot.kotlinPoc.dataSource.mock

import com.capgemini.springboot.kotlinPoc.dataSource.UserDataSource
import com.capgemini.springboot.kotlinPoc.model.User
import org.springframework.stereotype.Repository

@Repository
class MockDataSource: UserDataSource {

    val users = mutableListOf(
        User(accountNumber = "KOT001", name = "Shubham Paul", gander = "Male"),
        User(accountNumber = "KOT002", name = "Anirudha C", gander = "Male"),
        User(accountNumber = "KOT003", name = "Shubham Gupta", gander = "Male")
    )

    override fun getAllUsers(): Collection<User> {
        return users
    }

    override fun getUser(accountNumber: String): User {
        return users.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("User Does Not Exists")
    }

    override fun addNewUser(user: User): User {
        users.add(user)
        return user
    }

}