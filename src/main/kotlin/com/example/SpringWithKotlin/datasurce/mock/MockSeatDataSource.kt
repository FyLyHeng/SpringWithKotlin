package com.example.SpringWithKotlin.datasurce.mock

import com.example.SpringWithKotlin.datasurce.SeatDataSource
import com.example.SpringWithKotlin.model.Seat
import org.springframework.stereotype.Repository

@Repository
class MockSeatDataSource  {
/*
    private val seats = listOf(
            Seat(0,"A", 1, 3.2, "Good A view"),
            Seat(1,"B", 1, 3.2, "Good B view")
    )


    override fun getPrice(row: Int, num: Int): Double {
        TODO("Not yet implemented")
    }

    override fun getDescription(row: Int, num: Int): String {
        return when {
            row == 15->"back row"
            row ==14 ->"Cheaper Seat"
            num in 3..34 ->"Nice view"
            else -> "Standard Seat"
        }
    }

    override fun retriveSeat(row: String, num: Int): Seat {
        return seats.firstOrNull() {it.row == row && it.num == num}?:throw NoSuchElementException("Account number not found ")
    }

    override fun retriveSeat(): Collection<Seat> = seats*/
}