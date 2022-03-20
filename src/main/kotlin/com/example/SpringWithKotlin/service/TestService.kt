package com.example.SpringWithKotlin.service

import com.example.SpringWithKotlin.model.Test
import org.springframework.stereotype.Service
import java.util.*

@Service
class TestService( ) {

//    fun listAllTest(): Optional<Test> {
//        //return multiExtands.getTest()
//    }
    
    fun getTest(): List<Test> {
        return listOf<Test>()
    }
}