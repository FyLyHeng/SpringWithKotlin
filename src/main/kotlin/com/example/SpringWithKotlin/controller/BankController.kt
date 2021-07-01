package com.example.SpringWithKotlin.controller

import com.example.SpringWithKotlin.model.Bank
import com.example.SpringWithKotlin.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/bank")
class BankController(private val bankService: BankService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e:NoSuchElementException):ResponseEntity<String>{
        return ResponseEntity(e.message,HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBedRequest(e:IllegalArgumentException):ResponseEntity<String>{
        return ResponseEntity(e.message,HttpStatus.BAD_REQUEST)
    }

    @GetMapping
    fun getListBanks(): Collection<Bank> {
        return bankService.getBanks()
    }

    @GetMapping("/{accountCode}")
    fun getBank(@PathVariable accountCode:String): Any {
        return bankService.getBank(accountCode)
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addBank(@RequestBody bank: Bank) : Bank{
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
}