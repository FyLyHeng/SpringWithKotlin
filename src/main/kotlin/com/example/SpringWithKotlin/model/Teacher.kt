package com.example.SpringWithKotlin.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.Cascade
import javax.persistence.*

@Entity
data class Teacher(

        @Id
//        @SequenceGenerator(name = "teacher_seq", sequenceName = "teacher_seq",allocationSize = 1)
//        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Long,
        var name:String,

        //@JsonIgnore
        @OneToMany(mappedBy = "teacher",cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var subject: MutableList<Subject>? = null
)
