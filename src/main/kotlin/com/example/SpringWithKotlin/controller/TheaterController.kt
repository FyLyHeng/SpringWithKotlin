package com.example.SpringWithKotlin.controller

import com.example.SpringWithKotlin.datasurce.mock.DTO.CheckSeatDTO
import com.example.SpringWithKotlin.service.SeatService
import com.example.SpringWithKotlin.service.TheaterReportService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import javax.websocket.server.PathParam


/**
 * Work with Html view rest Controller not work
 * This look like full stack application
 *
 * by change to use @constructor for stand
 */
//@RequestMapping("/theater")
//@RestController

@Controller
class TheaterController(
        private val seatService: SeatService,
        private val reportService: TheaterReportService
) {

    @RequestMapping("/theater")
    fun getSetBooking(): ModelAndView {
        return ModelAndView("seatBooking", "bean", CheckSeatDTO())
    }


    /**
     * @NOTED: this end point will invoke vai other page. not derict kill rest api
     *         in face this is have call by submit button in seatBooking page.
     *
     *
     * @params: /addBooking is the from - data submit form page seatBooking.
     * @Form_value : bean. will set new value that get form form
     */
    @RequestMapping(value = ["/addBooking"], method = [RequestMethod.POST])
    fun addBooking(bean: CheckSeatDTO): ModelAndView {
        bean.result = "YOUR SEAT IS ${bean.selectedSeatRow}${bean.selectedSeatNum}"
        return ModelAndView("ConfirmBooking", "bean", bean)
    }


    @RequestMapping("/report")
    fun selectReport(): ModelAndView {
        val listReportType =  reportService.listReportType()
        val bean = mapOf("report" to listReportType)

        return ModelAndView("report",bean)
    }


    @RequestMapping("/report/detail")
    fun report(@PathParam("report") report:String):ModelAndView{
        val listReportType =  reportService.listReportType()
        val featchReport = reportService.getReportType(report)
        val bean = mapOf("report" to listReportType,"result" to featchReport)

        println("report $report")
        println("featchReport$featchReport")



        return ModelAndView("report",bean)
    }
}
