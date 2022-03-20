package com.example.SpringWithKotlin.datasurce.mysqlDatasource

import com.example.SpringWithKotlin.model.Test
import org.springframework.data.jpa.repository.JpaRepository


interface teatRepo : JpaRepository<Test,Long>{
}