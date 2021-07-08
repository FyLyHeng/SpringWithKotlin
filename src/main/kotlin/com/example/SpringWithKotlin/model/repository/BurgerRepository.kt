package com.example.SpringWithKotlin.model.repository

import com.example.SpringWithKotlin.model.Burger
import org.springframework.data.jpa.repository.JpaRepository

interface BurgerRepository:JpaRepository<Burger,Long> {

}