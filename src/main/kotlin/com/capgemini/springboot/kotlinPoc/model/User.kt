package com.capgemini.springboot.kotlinPoc.model

import com.fasterxml.jackson.annotation.JsonProperty

data class User(

    @JsonProperty("account_number")
    val accountNumber: String,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("gander")
    val gander: String
)
