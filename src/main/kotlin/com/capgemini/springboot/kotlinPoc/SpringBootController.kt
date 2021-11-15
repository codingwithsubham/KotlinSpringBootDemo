package com.capgemini.springboot.kotlinPoc;

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hello")
public class SpringBootController {

    @GetMapping
    fun hello(): String {
        return "Hello Kotlin!"
    }
}
