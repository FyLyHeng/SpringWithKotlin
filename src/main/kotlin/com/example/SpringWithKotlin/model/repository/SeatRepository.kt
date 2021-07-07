package com.example.SpringWithKotlin.model.repository

import com.example.SpringWithKotlin.model.Seat
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SeatRepository: JpaRepository<Seat,Long> {

    fun findAllSeatByPrice(price:Double):Optional<Seat>

    fun findAllBySeatRowAndSeatNum(seatRow:String,seatNum:Int):Optional<Seat>
}