package com.example.SpringWithKotlin.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Bank(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(updatable = false)
        val id: Long,

        @Column(unique = true, nullable = true)
        var accountCode: String,

        @Transient //not store this field in DB
        var trust: Double = 0.0,

        var transactionFee: Int,

        @Column(columnDefinition = "TEXT")
        @JsonIgnore // not show this field in render
        var description: String? = null,

        @Version
        var version: Int? = 0
) {

    init {
        trust = when {
            accountCode.length > 5 -> 10.0
            accountCode.length > 5 && transactionFee > 10 -> 20.0
            else -> 0.0
        }
    }
}