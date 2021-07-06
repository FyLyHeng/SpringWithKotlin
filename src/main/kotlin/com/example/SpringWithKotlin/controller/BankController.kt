package com.example.SpringWithKotlin.controller

import ControllerExceptionHandler.BaseClassHandler
import ControllerExceptionHandler.RespondDTO
import com.example.SpringWithKotlin.model.Bank
import com.example.SpringWithKotlin.model.Seat
import com.example.SpringWithKotlin.service.BankService
import org.springframework.data.repository.query.Param
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.*
import java.io.IOException


@RestController
@RequestMapping("/bank")
class BankController constructor (private val bankService: BankService) : BaseClassHandler() {

/*    @GetMapping
    fun getListBanks(): Collection<Bank> {
        return bankService.getBanks()
    }*/

    @GetMapping("/{accountCode}")
    fun getBank(@PathVariable accountCode:String): Any {
        val result = bankService.getAllBank(accountCode)


        return if (result.isPresent) {
            renderJSONFormat(result)
        }else{
            renderJSONFormat(data = result, statusCode = HttpStatus.NOT_FOUND.value(),message = "Account not exist with given accountCode $accountCode")
        }
    }

    @GetMapping
    fun getBankByFilter(@RequestParam filters: HashMap<String, Any>): Any {

        println("api filter by params $filters")
        println("api filter by params ${filters["trust"] as Double}")

        val result = bankService.getAllBank(filters["trust"] as Double)

        return if (result.isPresent) {
            renderJSONFormat(result)
        }else{
            renderJSONFormat(data = result, statusCode = HttpStatus.NOT_FOUND.value(), message = "Account not exist with given accountCode ${filters["trust"] as Double}")
        }
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addBank(@RequestBody bank: Bank) : Bank{

        println(bank.toString())

        return bankService.addBank(bank)
    }


    @PatchMapping
    fun updateBank(@RequestBody bank: Bank): Bank {
        return bankService.updateBank(bank)
    }

    @DeleteMapping("/{accountCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBank(@PathVariable accountCode: String){
        return bankService.deleteBank(accountCode)
    }



    @GetMapping("/testingSeat")
    fun testingSeat(): ResponseEntity<RespondDTO> {
        println("me here")
        return renderJSONFormat(bankService.testingCallOtherService())
    }
}