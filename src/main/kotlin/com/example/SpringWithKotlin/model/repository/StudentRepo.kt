package com.example.SpringWithKotlin.model.repository

import com.example.SpringWithKotlin.model.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepo : JpaRepository<Student,Long> {
}