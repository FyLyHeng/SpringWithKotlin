package com.example.SpringWithKotlin.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Bank (

        @JsonProperty("title")
        val accountCode:String,

        @JsonProperty("userId")
        val trust :Double,

        @JsonProperty("id")
        val transactionFee : Int
)