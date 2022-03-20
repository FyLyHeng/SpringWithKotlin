package com.example.SpringWithKotlin.datasurce.mock

import com.example.SpringWithKotlin.model.Test
import org.springframework.beans.factory.annotation.Qualifier
import java.util.*

@Qualifier("mock")
class TestMockDataSource {

    fun getTest(): Optional<Test> {
        return Optional.of(Test(1,"liza"))
    }
}