package com.example.SpringWithKotlin.model.repository

import com.example.SpringWithKotlin.model.Subject
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional

@Transactional
interface SubjectRepo:JpaRepository<Subject,Long> {


    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM student_subject WHERE subject_id = :subjectId AND student_id IN (:studentID)", nativeQuery = true)
    fun removeStudents(@Param ("subjectId") subjectId:Long, @Param("studentID") studentID : List<Long>
    )
}