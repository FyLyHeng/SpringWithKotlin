package com.example.SpringWithKotlin.service.sampleValidation

interface CURDOperation<T> {

    fun isExist(id: Long):T

    fun isValid(t:T):T


}