package com.capgemini.springboot.kotlinPoc.dataSource

import com.capgemini.springboot.kotlinPoc.model.User

interface UserDataSource {
    fun getAllUsers(): Collection<User>
    fun getUser(accountNumber: String): User
    fun addNewUser(user: User): User
}