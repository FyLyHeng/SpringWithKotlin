package com.example.SpringWithKotlin.datasurce.network

import com.example.SpringWithKotlin.datasurce.BankDataSource
import com.example.SpringWithKotlin.datasurce.network.DTO.BankList
import com.example.SpringWithKotlin.model.Bank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.web.client.getForObject


@Repository("network")
class NetworkDataSource( @Autowired private val restTemplate: RestTemplate) : BankDataSource {


    override fun retrieveBanks(): Collection<Bank> {
//        val response: ResponseEntity<BankList> = restTemplate.getForEntity("http://jsonplaceholder.typicode.com/posts")
//
//        println(response.body)

        testCall()

        return listOf(Bank("12",1.1,2))

    }


    fun testCall() {
        val response: BankList = restTemplate.getForObject("http://jsonplaceholder.typicode.com/todos")
        println(response.resultList)
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