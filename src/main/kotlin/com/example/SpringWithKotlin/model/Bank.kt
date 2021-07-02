package com.example.SpringWithKotlin.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Bank (

        @JsonProperty("node_idaa")
        val accountCode:String,

        @JsonProperty("id")
        val trust :Double,

        @JsonProperty("watchers")
        val transactionFee : Int
)