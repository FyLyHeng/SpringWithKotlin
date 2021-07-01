package com.example.SpringWithKotlin.datasurce.network.DTO

import com.example.SpringWithKotlin.model.Bank

data class BankList (
        val resultList : Collection<Bank>
        )