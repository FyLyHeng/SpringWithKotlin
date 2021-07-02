package com.example.SpringWithKotlin.controller

import com.example.SpringWithKotlin.datasurce.mock.DTO.CheckSeatDTO
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/theater")
class TheaterController {

    @GetMapping
    fun getSetBooking():ModelAndView = ModelAndView("seatBooking","bean", CheckSeatDTO())

    @PostMapping
    fun addBooking(bean:CheckSeatDTO):ModelAndView{

        return  ModelAndView("seatBooking","bean", CheckSeatDTO())
    }
}
