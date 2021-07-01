package com.example.SpringWithKotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController

@RequestMapping("api/hello")
class HelloController {

    @GetMapping
    fun sayHello() :String = "Hello to u kotlin in spring boot!"
}