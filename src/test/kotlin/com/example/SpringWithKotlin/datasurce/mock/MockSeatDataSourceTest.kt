package com.example.SpringWithKotlin.datasurce.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows as assertThrows1

internal class MockSeatDataSourceTest{


    val mockSeatDataSource = MockSeatDataSource()

    @Test
    fun `should return all seat`(){
        //given
        val listSeats = mockSeatDataSource.retriveSeat()

        //when
        assertThat(listSeats).isNotEmpty
        assertThat(listSeats).size().isGreaterThanOrEqualTo(2)
        //then
    }

    @Test
    fun `should return not found if Row Or Seat Num not Exist`(){
        //given
        val row = "C"
        val seatNum = 3

        //when.then
        assertThrows(NoSuchElementException::class.java){
            mockSeatDataSource.retriveSeat(row,seatNum)
        }
    }
}