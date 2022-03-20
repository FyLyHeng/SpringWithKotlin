package com.example.SpringWithKotlin.model.repository

import com.example.SpringWithKotlin.model.Burger
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import java.util.*
import javax.transaction.Transactional

@Transactional
interface BurgerRepository:JpaRepository<Burger,Long> {

    override fun findById(id: Long): Optional<Burger>


    @Query(value = "select b.id,b.name, b.price from Burger b",nativeQuery = true)
    fun listAllNameAndPrice() : Collection<Map<String,Any>>

    @Query(value = "select * from Burger b where b.id = ?1 or b.name like ?2",nativeQuery = true)
    fun findAllBurgerByIdOrNameUsingNativeQSL(id:Long, name:String):Collection<Burger>


    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Burger b SET b.name = ?2, b.price = ?3 WHERE b.id = ?1",nativeQuery = true)
    fun updateBurgerUsingNativeSQL(id: Long,name: String,price:Double):Int
}