package com.example.SpringWithKotlin.model

import javax.persistence.*

@Entity
data class Test (
        @Id
        @SequenceGenerator(name = "test_seq", sequenceName = "test_seq",allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_seq")
        var id:Long,
        var name:String,
        )