package com.example.SpringWithKotlin.model

import javax.persistence.*


@Entity
data class Burger(
        @Id @GeneratedValue(strategy =  GenerationType.AUTO) @Column(updatable = false)
        var id:Long,

        @Version
        var version: Int,

        @Column(unique = true)
        var name:String,
        var price:Double,

        @Column(columnDefinition = "TEXT")
        var description:String?=null
)
