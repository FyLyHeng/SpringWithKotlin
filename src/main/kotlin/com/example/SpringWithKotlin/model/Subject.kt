package com.example.SpringWithKotlin.model

import javax.persistence.*

@Entity
data class Subject(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        var name: String,

        @ManyToMany(cascade = [CascadeType.ALL],fetch = FetchType.EAGER)
        @JoinTable(name = "student_subject", joinColumns = [JoinColumn(name = "subject_id",referencedColumnName = "id")], inverseJoinColumns = [JoinColumn(name = "student_id",referencedColumnName = "id")])
        var students: MutableList<Student> = mutableListOf(),

//        @Column(nullable = true)
        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "teacher_id",referencedColumnName = "id")
        var teacher: Teacher?=null
)
