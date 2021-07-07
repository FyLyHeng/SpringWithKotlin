package com.example.SpringWithKotlin.service

import com.example.SpringWithKotlin.model.Bank
import com.example.SpringWithKotlin.model.Seat
import com.example.SpringWithKotlin.model.repository.BankRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class BankService( private val dataSource: BankRepository,private val seatService: SeatService) {

    fun getBanks():Collection<Bank>{
        return dataSource.findAll()
    }

    fun getBank(accountCode:String): Optional<Bank> {
        return dataSource.findByAccountCode(accountCode)
    }

    fun getAllBank(accountCode: String):Optional<Bank>{
        return dataSource.findAllByAccountCode(accountCode)
    }

    fun filterBeak(transactionFee:Int,accountCode: String):Optional<Bank>{
        return dataSource.findAllByTransactionFeeOrAccountCode(transactionFee,accountCode)
    }

    @Transactional
    fun addBank(bank: Bank):Bank{
        dataSource.save(bank)

        return dataSource.getById(bank.id)
    }

    @Transactional
    fun updateBank(bank: Bank): Bank {
        return dataSource.save(bank)
    }

    fun deleteBank(accountCode: String) {
        return dataSource.deleteById(1)
    }

    fun testingCallOtherService(): MutableList<Seat> {
        println("this service call sub service")
        return seatService.getSeat()
    }
}