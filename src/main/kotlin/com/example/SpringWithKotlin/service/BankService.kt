package com.example.SpringWithKotlin.service

import com.example.SpringWithKotlin.datasurce.BankDataSource
import com.example.SpringWithKotlin.model.Bank
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class BankService(@Qualifier("network") private val dataSource: BankDataSource) {

    fun getBanks():Collection<Bank>{
        return dataSource.retrieveBanks()
    }

    fun getBank(accountCode:String):Bank{
        return dataSource.retrieveBank(accountCode)
    }

    fun addBank(bank: Bank):Bank{
        return dataSource.createBank(bank)
    }

    fun updateBank(bank: Bank): Bank {
        return dataSource.updateBank(bank)
    }

    fun deleteBank(accountCode: String) {
        return dataSource.deleteBank(accountCode)
    }
}