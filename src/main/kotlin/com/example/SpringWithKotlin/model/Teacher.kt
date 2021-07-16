package com.example.SpringWithKotlin.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Teacher(

        @Id
        @SequenceGenerator(name = "teacher_seq", sequenceName = "teacher_seq",allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq")
        var id:Long,
        var name:String,

        @JsonIgnore
        @OneToMany(mappedBy = "teacher",cascade = [CascadeType.ALL], orphanRemoval = true)
        var subject: MutableList<Subject> = mutableListOf()
)
