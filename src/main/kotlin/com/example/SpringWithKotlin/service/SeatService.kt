package com.example.SpringWithKotlin.service

import com.example.SpringWithKotlin.model.Seat
import com.example.SpringWithKotlin.model.repository.SeatRepository
import org.springframework.stereotype.Service
import java.util.*


@Service
class SeatService ( private val seatDataSource: SeatRepository) {

    fun getSeat(): MutableList<Seat> {
        return seatDataSource.findAll()
    }

    fun getSeatById(id:Long):Seat{
        return seatDataSource.getById(id)
    }

    fun getSeats(price:Double): Optional<Seat> {
        return seatDataSource.findAllSeatByPrice(price)
    }

}