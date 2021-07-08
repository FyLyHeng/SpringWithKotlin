package com.example.SpringWithKotlin.service

import com.example.SpringWithKotlin.model.Burger
import com.example.SpringWithKotlin.model.repository.BurgerRepository
import org.springframework.stereotype.Service

@Service
class BurgerService(private val burgerRepository: BurgerRepository) {

    fun listAllBurger(): MutableList<Burger> {
        return burgerRepository.findAll()
    }
}