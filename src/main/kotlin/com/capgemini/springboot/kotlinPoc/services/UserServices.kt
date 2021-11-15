package com.capgemini.springboot.kotlinPoc.services

import com.capgemini.springboot.kotlinPoc.dataSource.UserDataSource
import com.capgemini.springboot.kotlinPoc.model.User
import org.springframework.stereotype.Service

@Service
class UserServices(private val dataSource: UserDataSource) {
    fun getAllUsers(): Collection<User> {
        return dataSource.getAllUsers()
    }

    fun getUser(accountNumber: String): User {
        return dataSource.getUser(accountNumber)
    }

    fun addNewUser(user: User): User {
        return dataSource.addNewUser(user)
    }

}