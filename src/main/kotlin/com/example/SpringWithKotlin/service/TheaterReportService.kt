package com.example.SpringWithKotlin.service

import org.springframework.stereotype.Service
import kotlin.reflect.full.declaredMemberExtensionFunctions
import kotlin.reflect.full.declaredMemberFunctions

@Service
class TheaterReportService(private val seatService: SeatService) {

    val reportHeader = "<table><tr><ht>Seat No</th><ht>Price</th><ht>description</th></tr>"
    val footer = "</table>"

    fun `Report All` (): String {
        val allBooking = seatService.getSeat()
        val htmlFormat = allBooking.map { "<tr><dt>${it.seatRow}${it.seatNum}</td><td>${it.price}</td><td>${it.description}</td></tr>" }
        return "${reportHeader}${htmlFormat.joinToString()}${footer}"
    }

    fun `Report By Price` (): String {
        val result = seatService.getSeats(2.3)
        val htmlFormatByPrice = result.map { "<tr><dt>${it.seatRow}${it.seatNum}</td><td>${it.price}</td><td>${it.description}</td></tr>" }
        return "${reportHeader}${htmlFormatByPrice}${footer}"
    }

    fun getReportType(report:String): Any {
        val reportType = this::class.declaredMemberFunctions.filter { it.name == report }.firstOrNull()
        val result = reportType?.call(this)?:""

        return result
    }

    fun listReportType(): List<String> {
        return this::class.declaredMemberFunctions.filter { it.name.contains(" ") }.map { it.name }
    }

}