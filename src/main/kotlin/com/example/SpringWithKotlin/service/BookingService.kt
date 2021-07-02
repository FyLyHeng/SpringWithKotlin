package com.example.SpringWithKotlin.service

import com.example.SpringWithKotlin.model.Seat
import org.springframework.stereotype.Service

@Service
class BookingService {

    fun isSeatFree(seat:Seat):Boolean{
        return true
    }
}