package com.example.SpringWithKotlin.controller

import ControllerExceptionHandler.RespondDTO.RespondDTO
import ControllerExceptionHandler.RespondDTO.renderJSONFormat
import ControllerExceptionHandler.SimpleGenericRestfulController
import com.example.SpringWithKotlin.service.BurgerService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView


@Controller
@RequestMapping("/burger")
class BurgerController(private val burgerService: BurgerService) : SimpleGenericRestfulController() {


    @GetMapping("/home")
    fun homePage(): ModelAndView {

        val listBurger = burgerService.listAllBurger()
        println(listBurger.forEach { it.currency() })

        // the repo return the custom sql query column, By using @Query()
        val customerField = burgerService.listNameAndPrice()
        customerField.forEach { println(it["name"]) }
        return ModelAndView("/foodPage/index", "data", mapOf("bur" to listBurger, "burgers" to customerField))
    }


    @GetMapping
    fun getBurger(): ResponseEntity<RespondDTO> {
        return renderJSONFormat(burgerService.listAllBurger())
    }

    @GetMapping("/customQuery")
    fun getBurgerCustomQuery(): ResponseEntity<RespondDTO> {
        //using @Query()
        val customQuery = burgerService.listAllBurger(1, "Burger M")
        return renderJSONFormat(customQuery)
    }


    /**
     * Using @PathVariable
     * Not need key
     * But value passing into api need order
     *
     *
     * @EX: {url}/burger/1/burger name
     */
    @PutMapping("/{id}/{name}")
    fun updateBurgerById(@PathVariable id: Long, @PathVariable name: String): ResponseEntity<RespondDTO> {
        return renderJSONFormat(burgerService.updateBurgerById(id, name))
    }


    /**
     * Using RequestParam specific field
     * Params are <key, value>
     * With specific field
     *
     * The Default value set with build_in @RequestParam defaultValue
     */
    @PutMapping("/nativeSQL/{id}")
    fun updateBurgerUsingNativeSQL(@PathVariable id: Long,
                                   @RequestParam(required = false) name: String,
                                   @RequestParam(required = false, defaultValue = "-1") price: Double): ResponseEntity<RespondDTO> {
        return renderJSONFormat(burgerService.updateBurgerByIdNativeSQL(id, name, price))
    }



    /**
     * Using params map<k,v>
     * The Default value set at fun parameter
     */
    @PutMapping("/multiParams/{id}")
    fun updateBurgerUsingNativeSQLAndParams(@PathVariable id: Long, @RequestParam allParams: Map<String, String>): ResponseEntity<RespondDTO> {
        val result = burgerService.updateBurgerByIdNativeSQL(
                id = id,
                name = allParams["name"].toString(),
                price = allParams["price"]?.toDouble() ?: 0.toDouble()
        )
        return renderJSONFormat(result)
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<RespondDTO>{
        burgerService.delete(id)
        return renderJSONFormat("")
    }

}