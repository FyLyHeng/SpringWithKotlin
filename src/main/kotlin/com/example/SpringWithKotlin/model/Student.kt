package com.example.SpringWithKotlin.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
data class Student(
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
        var id:Long,
        var name:String,

       @JsonIgnore
       @ManyToMany(mappedBy = "students",cascade = [CascadeType.ALL],fetch = FetchType.EAGER)
       @Fetch(value= FetchMode.SELECT)
        var subjects: MutableSet<Subject> = mutableSetOf()
)
