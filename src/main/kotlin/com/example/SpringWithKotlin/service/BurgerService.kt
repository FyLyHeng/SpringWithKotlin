package com.example.SpringWithKotlin.service

import com.example.SpringWithKotlin.model.Burger
import com.example.SpringWithKotlin.model.repository.BurgerRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException
import kotlin.NoSuchElementException

@Service
class BurgerService(private val burgerRepository: BurgerRepository) {

    fun listAllBurger(): MutableList<Burger> {
        return burgerRepository.findAll()
    }

    /**
     * This service we custom select column form database using Collection<Map>
     */
    fun listNameAndPrice(): Collection<Map<String,Any>> {
        return burgerRepository.listAllNameAndPrice()
    }


    /**
     * This service we select DB using native sql query with parameter
     */
    fun listAllBurger(id:Long,name:String): Any {
        return burgerRepository.findAllBurgerByIdOrNameUsingNativeQSL(id,name)
    }


    /**
     * Update table rows using JPA save
     */
    fun updateBurgerById(id:Long, name:String) : Burger{
        val burger: Burger = burgerRepository.getById(id) ?: throw NoSuchElementException("Burger Id not exist!")
        burger.name = name
        return burgerRepository.save(burger)
    }


    /**
     * Update table row using Native SQL
     */
    fun updateBurgerByIdNativeSQL(id: Long,name: String,price:Double): Burger {
        val updatedId = if (burgerRepository.updateBurgerUsingNativeSQL(id,name,price)!=0) id else throw EntityNotFoundException("Burger id gavin not exist $id")
        return burgerRepository.getById(updatedId)
    }

    fun delete(id: Long) {
        burgerRepository.deleteById(id)
    }
}