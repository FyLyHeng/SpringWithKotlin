package com.example.SpringWithKotlin.service

import com.example.SpringWithKotlin.model.Burger
import com.example.SpringWithKotlin.model.repository.BurgerRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SeedData(private val burgerService: BurgerService,private val burgerRepository: BurgerRepository) : CommandLineRunner {
    /**
     * Callback used to run the bean.
     * @param args incoming main method arguments
     * @throws Exception on error
     */

    override fun run(vararg args: String?) {
//        when {
//            burgerRepository.findById(1000).isEmpty -> {
//                burgerRepository.save(Burger(1000,0,"Burger Big",1.2))
//            }
//        }
    }
}