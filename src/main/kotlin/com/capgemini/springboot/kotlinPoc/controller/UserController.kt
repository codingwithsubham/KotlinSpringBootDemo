package com.capgemini.springboot.kotlinPoc.controller

import com.capgemini.springboot.kotlinPoc.model.User
import com.capgemini.springboot.kotlinPoc.services.UserServices
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.NoSuchElementException

@RestController
@RequestMapping("/api/users")
class UserController(private val service: UserServices) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @GetMapping
    fun getAllUsers(): Collection<User> = service.getAllUsers()

    @GetMapping("/{accountNumber}")
    fun getUser (@PathVariable accountNumber: String): User = service.getUser(accountNumber)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun  addNewUser(@RequestBody user: User): User = service.addNewUser(user)
}