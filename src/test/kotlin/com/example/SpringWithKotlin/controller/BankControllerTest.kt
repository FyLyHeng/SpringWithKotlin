package com.example.SpringWithKotlin.controller

import com.example.SpringWithKotlin.model.Bank
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.*

@SpringBootTest
@AutoConfigureMockMvc
internal class BankControllerTest @Autowired constructor(val mockmvc: MockMvc, val objectMapper: ObjectMapper) {


    /*@Test
    fun `should return all banks`() {
        //when/then
        mockmvc.get("/bank")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$[0].accountCode") { value("1234") }
                }
    }

    @Test
    fun `should return the bank gaven account code `() {
        //given
        val accountCode = "1234"

        //when/then
        mockmvc.get("/bank/$accountCode")
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.trust") { value(1.5) }
                }
    }

    @Test
    fun `should return not found if account code not exist`() {
        //given
        val accountCode = "valid_account_code"

        //when
        mockmvc.get("/bank/${accountCode}")

                //then
                .andDo { print() }
                .andExpect { status { isNotFound() } }
    }
    
    @Test
    fun `should add success new Bank`(){
        //given
        val newBank = Bank(1,"1.5",10.8,1)
        
        //when
        val performPost = mockmvc.post("/bank"){
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newBank)
        }
        
        //then
        performPost
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.accountCode") {value("a123")}
                }
    }

    @Test
    fun `should return Bed request if accountCode is already exist`(){
        //given
        val newBank = Bank("0001",1.0,1)
        //when
        val performPost = mockmvc.post("/bank"){
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newBank)
        }

        //then
        performPost
                .andDo { print() }
                .andExpect {
                    status { isBadRequest() }
                }

    }


    @Test
    fun `should update an existing bank`(){
        //given
        val updateBank = Bank("1234",12.4,1)

        //when
        val performPatch = mockmvc.patch("/bank"){
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(updateBank)
        }

        //then
        performPatch
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                        json(objectMapper.writeValueAsString(updateBank))
                    }
                }

        //use this for check does all data that pass in each field have return match all. (all data that pass for update and the return need the same)
        mockmvc.get("/bank/${updateBank.accountCode}")
                .andExpect { content { json(objectMapper.writeValueAsString(updateBank)) } }
    }
    
    
    @Test
    fun `should return BED Request if on Bank with giving account number exist`(){
        //given
        val inValidBank = Bank("@@@@",1.2,1)
        
        //when
        val performPatch = mockmvc.patch("/bank") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(inValidBank)
        }
        
        //then
        performPatch
                .andDo { print() }
                .andExpect { status { isBadRequest() } }

    } 
    
    
    @Test
    @DirtiesContext
    fun `should delete the bank with the given account code`(){
        //given
        val accountCode = 1234
        
        //when
        val performDelete = mockmvc.delete("/bank/$accountCode")
        
        //then
        performDelete
                .andDo { print() }
                .andExpect {
                    status { isNoContent() }
                }

        //if delete success should return status not found
        mockmvc.get("/bank/$accountCode")
                .andExpect { status { isNotFound() } }
    }

    @Test
    fun `should return NOT Found if no bank with given account number exists`(){
        //given
        val invalidAccountCode = "1@"

        //when
        val performDelete = mockmvc.delete("/bank/$invalidAccountCode")

        //then
        performDelete
                .andDo { print() }
                .andExpect {
                    status { isNotFound() }
                }
    }*/

}