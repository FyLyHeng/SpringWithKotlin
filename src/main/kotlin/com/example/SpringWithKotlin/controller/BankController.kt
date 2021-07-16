package com.example.SpringWithKotlin.controller

import ControllerExceptionHandler.RespondDTO.RespondDTO
import ControllerExceptionHandler.RespondDTO.renderJSONFormat
import ControllerExceptionHandler.SimpleGenericRestfulController
import com.example.SpringWithKotlin.model.Bank
import com.example.SpringWithKotlin.service.BankService
import org.apache.catalina.filters.RequestFilter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/bank")
class BankController (private val bankService: BankService) : SimpleGenericRestfulController<Bank>() {

    /**
     * Old style check isExist in controller
     */
    @GetMapping("/{accountCode}")
    fun getBank(@PathVariable accountCode:String): Any {
        val result = bankService.getAllBank(accountCode)
        return if (result.isPresent) {
            renderJSONFormat(result)
        }else{
            renderJSONFormat(data = result, statusCode = HttpStatus.NOT_FOUND.value(),message = "Account not exist with given accountCode $accountCode")
        }
    }

    //TODO allow filter by params multi opstiontal
    @GetMapping
    fun getBankByFilter(@RequestParam(required = false) accountCode: String, @RequestParam(required = false) transactionFee:Int): Any {

        println("api filter by params ${RequestFilter::class.typeParameters}")

        val result = bankService.filterBeak(transactionFee,accountCode)

        return if (result.isPresent) {
            renderJSONFormat(result)
        }else renderJSONFormat(data = result, statusCode = HttpStatus.NOT_FOUND.value(), message = "Account not exist with given accountCode")
    }


    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    fun addBank(@RequestBody bank: Bank) : ResponseEntity<RespondDTO> {
        bank.transactionFee = 100
        bankService.addBank(bank)

        return renderJSONFormat(bank)
    }


    @PatchMapping("/{id}")
    fun updateBank(@PathVariable id:Long, @RequestBody bank: Bank): ResponseEntity<RespondDTO> {
        return renderJSONFormat(data = bankService.updateBank(id,bank))
    }

    @DeleteMapping("/{accountCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBank(@PathVariable accountCode: String){
        return bankService.deleteBank(accountCode)
    }



    @GetMapping("/testingSeat")
    fun testingSeat(): ResponseEntity<RespondDTO> {
        return renderJSONFormat(bankService.testingCallOtherService())
    }
}