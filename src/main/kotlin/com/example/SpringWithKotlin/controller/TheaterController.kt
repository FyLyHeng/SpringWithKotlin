package com.example.SpringWithKotlin.controller

import com.example.SpringWithKotlin.datasurce.mock.DTO.CheckSeatDTO
import com.example.SpringWithKotlin.service.SeatService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView


/**
 * Work with Html view rest Controller not work
 * by chenge to use @constructor for stand
 */
//@RequestMapping("/theater")
//@RestController

@Controller
class TheaterController(
        seatService: SeatService
) {

    @RequestMapping("/theater")
    fun getSetBooking():ModelAndView {
        return ModelAndView("seatBooking","bean", CheckSeatDTO())
    }


    /**
     * @params: /addBooking is the from - data submit form page seatBooking.
     * @Form_value : bean. will set new value that get form form
     */
    @RequestMapping(value = ["/addBooking"],method = [RequestMethod.POST])
    fun addBooking(bean:CheckSeatDTO):ModelAndView {
        bean.result = "YOUR SEAT IS ${bean.selectedSeatRow}${bean.selectedSeatNum}"
        return  ModelAndView("ConfirmBooking","bean",bean)
    }
}
