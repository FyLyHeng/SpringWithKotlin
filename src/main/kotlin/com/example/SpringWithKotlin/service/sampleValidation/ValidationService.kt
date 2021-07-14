package com.example.SpringWithKotlin.service.sampleValidation

abstract class ValidationService<T>(t:T) : CURDOperation<T> {

    override fun isExist(id: Long): T {
        TODO("Not yet implemented")
    }

    override fun isValid(t: T): T {
        TODO("Not yet implemented")
    }

}