package com.example.SpringWithKotlin.model.repository

import com.example.SpringWithKotlin.model.Teacher
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherRepo:JpaRepository<Teacher,Long> {

}