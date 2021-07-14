package com.example.SpringWithKotlin.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.text.NumberFormat
import java.util.*
import javax.persistence.*


@Entity
data class Burger(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(updatable = false)
        var id: Long,

        @Version
        var version: Int,

        @Column(unique = true)
        var name: String,

        var price: Double,

        @Column(columnDefinition = "TEXT")
        var description: String? = null
) {

    fun currency(): String = NumberFormat.getCurrencyInstance(Locale.US).format(price)
}
