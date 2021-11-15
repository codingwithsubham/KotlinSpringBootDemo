package com.capgemini.springboot.kotlinPoc.controller

import com.capgemini.springboot.kotlinPoc.model.User
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
internal class UserControllerTest @Autowired constructor(
    var mockMvc: MockMvc,
    var objectMapper: ObjectMapper
){
    //Test Classes
    @Test
    fun `should return all users`() {
        //when//then
        mockMvc.get("/api/users")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                jsonPath("$[0].account_number"){
                    value("KOT001")
                }
            }
    }

    @Test
    fun `should return an user with specific account number`() {
        //given
        val accNumber = "KOT001"

        //when//then
        mockMvc.get("/api/users/$accNumber")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                jsonPath("$.account_number"){
                    value(accNumber)
                }
            }
    }

    @Test
    fun `should not return any user with wrong account number`() {
        //given
        val accNumber = "KOT999"

        //when//then
        mockMvc.get("/api/users/$accNumber")
            .andDo { print() }
            .andExpect {
                status { isNotFound() }
            }
    }

    @Test
    fun `should return the new added User with valid Data`() {
        //given
        val user = User("KOT004","Jennie Doe","Female")

        //when
        val response = mockMvc.post("/api/users") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(user)
        }

        //then
        response.andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content { contentType(MediaType.APPLICATION_JSON)}
                 }
    }

}