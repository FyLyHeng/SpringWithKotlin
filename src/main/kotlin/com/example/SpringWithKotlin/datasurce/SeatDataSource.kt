package com.example.SpringWithKotlin.datasurce

import com.example.SpringWithKotlin.model.Seat

interface SeatDataSource {

    fun getPrice(row:Int,num:Int):Double

    fun getDescription(row: Int,num: Int):String

    fun retriveSeat(row: String, num: Int):Seat

    fun retriveSeat():Collection<Seat>
}