package com.example.SpringWithKotlin.InitConfiguration

import com.example.SpringWithKotlin.model.Bank
import com.example.SpringWithKotlin.model.Seat
import com.example.SpringWithKotlin.model.repository.BankRepository
import com.example.SpringWithKotlin.model.repository.SeatRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SeatConfiguration(private val repository: SeatRepository) : CommandLineRunner{
    /**
     * Callback used to run the bean.
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    override fun run(vararg args: String?) {
        //insert default Account
        if (repository.findAllBySeatRowAndSeatNum("A",1).isEmpty){
            repository.save(Seat(1,"A",1,3.5,"Default seat!"))
        }
    }
}