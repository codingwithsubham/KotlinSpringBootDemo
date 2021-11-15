package com.capgemini.springboot.kotlinPoc.dataSource.mock

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockDataSourceTest {

    private val mockDataSource: MockDataSource = MockDataSource()

    @Test
    fun `should provide a collection of users`() {
        // when
        val users  = mockDataSource.getAllUsers()

        // then
        assertThat(users.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide some mock data of users`() {
        // when
        val users  = mockDataSource.getAllUsers()

        // then
        assertThat(users).allMatch { it.accountNumber.isNotBlank() }
        assertThat(users).anyMatch { it.name.isNotBlank() }
        assertThat(users).anyMatch { it.gander.isNotBlank() }
    }
}


