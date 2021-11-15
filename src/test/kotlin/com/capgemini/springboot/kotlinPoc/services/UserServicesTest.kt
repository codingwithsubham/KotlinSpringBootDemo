package com.capgemini.springboot.kotlinPoc.services

import com.capgemini.springboot.kotlinPoc.dataSource.UserDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class UserServicesTest {

    private val dataSource: UserDataSource = mockk(relaxed = true)
    private val userService = UserServices(dataSource)

    @Test
    fun `should call it's data source`() {
        //given
        //every { dataSource.getAllUsers() } returns emptyList()

        //when
        userService.getAllUsers()

        //then
        verify(exactly = 1) { dataSource.getAllUsers()}
    }
}