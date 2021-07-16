package com.example.SpringWithKotlin.controller

import ControllerExceptionHandler.RespondDTO.RespondDTO
import ControllerExceptionHandler.RespondDTO.renderJSONFormat
import ControllerExceptionHandler.SimpleGenericRestfulController
import com.example.SpringWithKotlin.model.Student
import com.example.SpringWithKotlin.model.repository.StudentRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/student")
class StudentController(val studentRepo: StudentRepo) : SimpleGenericRestfulController<Student>() {


    @PostMapping
    override fun save(@RequestBody resource: Student): ResponseEntity<RespondDTO> {
        return renderJSONFormat(studentRepo.save(resource))
    }


    @GetMapping
    override fun getAction(): ResponseEntity<RespondDTO> {
        return renderJSONFormat(studentRepo.findAll())
    }
}