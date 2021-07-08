package com.example.SpringWithKotlin.controller

import com.example.SpringWithKotlin.service.BurgerService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import java.text.NumberFormat


@Controller
class BurgerController(private var burgerService: BurgerService) {


    @RequestMapping("/food")
    fun homePage(): ModelAndView {

        var format = NumberFormat.getCurrencyInstance()

        println("format")
        println(format)

        var listBurger = burgerService.listAllBurger()
        return ModelAndView("/foodPage/index","burgers",listBurger)
    }

}