package com.example.SpringWithKotlin.model

import javax.persistence.*

@Entity
data class Bank (
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(updatable = false)
        val id: Long,
//        @JsonProperty("node_idaa")

        @Column(unique = true,nullable = true)
        val accountCode:String,

//        @JsonProperty("id")
        val trust :Double,

//        @JsonProperty("watchers")
        val transactionFee : Int
)