package com.example.SpringWithKotlin.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Subject(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        var name: String,

//        @ManyToMany(cascade = [CascadeType.ALL],fetch = FetchType.EAGER)
//        @JoinTable(name = "student_subject", joinColumns = [JoinColumn(name = "subject_id",referencedColumnName = "id")], inverseJoinColumns = [JoinColumn(name = "student_id",referencedColumnName = "id")])
//        var students: MutableList<Student> = mutableListOf(),

//        @Column(nullable = true)
        @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        //@JoinColumn(name = "teacher_id",referencedColumnName = "id")
        @JsonIgnore
        var teacher: Teacher?=null
)
