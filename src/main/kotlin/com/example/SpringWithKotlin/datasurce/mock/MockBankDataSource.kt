package com.example.SpringWithKotlin.datasurce.mock

import com.example.SpringWithKotlin.datasurce.BankDataSource
import com.example.SpringWithKotlin.model.Bank
import org.springframework.stereotype.Repository


@Repository
class MockBankDataSource  {

/*    val banks = mutableListOf (
            Bank(1,"1.5",10.8,1),
            Bank(2,"1.5",10.8,1),
            Bank(3,"1.5",10.8,1),
    )

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun retrieveBank(accountCode: String): Bank {
        return banks.firstOrNull() {it.accountCode == accountCode}?:throw NoSuchElementException("Account number not found $accountCode")
    }

    override fun createBank(bank: Bank): Bank {
        if (banks.any{it.accountCode == bank.accountCode}) {
            throw IllegalArgumentException("Bank accountCode is already exist ${bank.accountCode}")
        }

        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentBank = getExistBank(bank.accountCode)
        banks.remove(currentBank)
        banks.add(bank)

        return bank
    }

    override fun deleteBank(accountCode: String) {
        val currentBank = banks.firstOrNull(){it.accountCode == accountCode}?:throw NoSuchElementException("cant not update Bank with not exist account Code $accountCode")
        banks.remove(currentBank)
    }

    // ========= sub service =============
    private fun getExistBank(accountCode: String):Bank {
        return banks.firstOrNull(){it.accountCode == accountCode}?:throw IllegalArgumentException("cant not update Bank with not exist account Code $accountCode")
    }*/
}