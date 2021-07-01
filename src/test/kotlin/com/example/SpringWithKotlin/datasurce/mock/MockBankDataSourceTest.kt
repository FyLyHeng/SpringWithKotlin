package com.example.SpringWithKotlin.datasurce.mock

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test


internal class MockBankDataSourceTest{
    private val mockDataSource = MockBankDataSource()

    @Test
    fun `should provide a list of bank`(){
        //given
        //when
        val banks = mockDataSource.retrieveBanks()
        //then
        assertThat(banks).isNotEmpty
        assertThat(banks).size().isGreaterThanOrEqualTo(3)
    }
    
    @Test
    fun `should be account number not contant blank`(){
        //given
        
        //when
        val banks = mockDataSource.retrieveBanks()
        
        //then
        assertThat(banks).allMatch { it.accountCode.isNotBlank() }
        assertThat(banks).anyMatch { it.trust != 0.0 }
        assertThat(banks).anyMatch { it.transactionFee != 0 }
    }



}