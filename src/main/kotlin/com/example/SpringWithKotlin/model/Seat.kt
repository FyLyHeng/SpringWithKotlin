package com.example.SpringWithKotlin.model

import javax.persistence.*


@Entity
data class Seat(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        val seatRow: String,
        val seatNum: Int,
        val price: Double,
        val description: String
)
