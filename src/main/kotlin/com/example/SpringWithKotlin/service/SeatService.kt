package com.example.SpringWithKotlin.service

import com.example.SpringWithKotlin.datasurce.SeatDataSource
import com.example.SpringWithKotlin.model.Seat
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service


@Service
class SeatService (@Qualifier("mock") private val seatDataSource: SeatDataSource) {

    fun getSeat(row:String,num:Int): Seat {
        return seatDataSource.retriveSeat(row,num)
    }

}