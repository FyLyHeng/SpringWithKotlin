package com.example.SpringWithKotlin.datasurce.mock.DTO

class CheckSeatDTO() {
    val seatRows = "A".."F"
    var selectedSeatRow = "A"
    var seatNums = 1..10
    var selectedSeatNum = 1
    var result = ""
}
