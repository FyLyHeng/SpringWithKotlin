package com.example.SpringWithKotlin.controller

import ControllerExceptionHandler.RespondDTO.RespondDTO
import ControllerExceptionHandler.RespondDTO.renderJSONFormat
import ControllerExceptionHandler.SimpleGenericRestfulController
import com.example.SpringWithKotlin.model.Teacher
import com.example.SpringWithKotlin.model.repository.TeacherRepo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/teacher")
class TeacherController(val teacherRepo: TeacherRepo): SimpleGenericRestfulController<Teacher>() {


    @PostMapping
    override fun saved(@RequestBody resource: Teacher): ResponseEntity<RespondDTO> {
        return renderJSONFormat(teacherRepo.save(resource))
    }


    @GetMapping
    override fun getAction(): ResponseEntity<RespondDTO> {
        return renderJSONFormat(teacherRepo.findAll())
    }

}
