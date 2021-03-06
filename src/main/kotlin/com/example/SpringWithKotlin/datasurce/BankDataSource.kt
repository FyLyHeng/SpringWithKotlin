package com.example.SpringWithKotlin.datasurce

import com.example.SpringWithKotlin.model.Bank
import org.springframework.data.jpa.repository.JpaRepository

interface BankDataSource  {
    fun retrieveBanks(): Collection<Bank>
    fun retrieveBank(accountCode: String): Bank
    fun createBank(bank: Bank) : Bank
    fun updateBank(bank: Bank): Bank
    fun deleteBank(accountCode: String)
}