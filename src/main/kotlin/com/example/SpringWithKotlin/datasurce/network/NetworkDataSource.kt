package com.example.SpringWithKotlin.datasurce.network

import com.example.SpringWithKotlin.datasurce.BankDataSource
import com.example.SpringWithKotlin.datasurce.network.DTO.BankList
import com.example.SpringWithKotlin.model.Bank
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.web.client.getForObject
import java.io.IOException


@Repository("network")
class NetworkDataSource( @Autowired private val restTemplate: RestTemplate) : BankDataSource {


    override fun retrieveBanks(): Collection<Bank> {
        val response: ResponseEntity<Any> = restTemplate.getForEntity("https://api.github.com/users/hadley/repos", BankList::class)

        val result = response.body.also { println(it) }

        println("Why many @@@")


        return listOf(Bank("2@",1.2,4))
       // return response.body?.resultList?:throw IOException("Could Not fetch banks from the Network")
    }




    override fun retrieveBank(accountCode: String): Bank {
        TODO("Not yet implemented")
    }

    override fun createBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun updateBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun deleteBank(accountCode: String) {
        TODO("Not yet implemented")
    }
}