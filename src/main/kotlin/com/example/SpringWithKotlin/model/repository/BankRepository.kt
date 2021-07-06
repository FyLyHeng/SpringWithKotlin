package com.example.SpringWithKotlin.model.repository

import com.example.SpringWithKotlin.model.Bank
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BankRepository: JpaRepository<Bank,Long> {

    fun findByAccountCode (accountCode:String) : Optional<Bank>

    fun findAllByAccountCode (accountCode: String): Optional<Bank>

    fun findAllByTrust(trust:Double):Optional<Bank>
}