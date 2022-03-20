package com.example.SpringWithKotlin.controller

import ControllerExceptionHandler.RespondDTO.RespondDTO
import ControllerExceptionHandler.RespondDTO.renderJSONFormat
import ControllerExceptionHandler.SimpleGenericRestfulController
import com.example.SpringWithKotlin.model.Teacher
import com.example.SpringWithKotlin.model.repository.TeacherRepo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional


@RestController
@RequestMapping("/teacher")
class TeacherController(val teacherRepo: TeacherRepo): SimpleGenericRestfulController<Teacher>() {


    @PostMapping
    override fun saved(@RequestBody resource: Teacher): ResponseEntity<RespondDTO> {
        resource.subject?.forEach {
            it.teacher = resource
        }
        return renderJSONFormat(teacherRepo.save(resource))
    }


    @GetMapping
    override fun getAction(): ResponseEntity<RespondDTO> {
        return renderJSONFormat(data = teacherRepo.findAll())
    }

    @GetMapping("/test")
    fun get(): MutableList<Teacher> {
        return teacherRepo.findAll()
    }


    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @PutMapping("/{id}")
    fun updateBank(@PathVariable id:Long, @RequestBody teacher: Teacher): Teacher {
        val obj = teacherRepo.getById(id)
        teacher.subject?.forEach {
            it.teacher = obj
            println("me loop-- ${it.teacher?.name}")
        }
        obj.subject = teacher.subject
        return teacherRepo.save(obj)
    }


    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @PatchMapping("/{id}")
    fun updateBank1(@PathVariable id:Long, @RequestBody teacher: Teacher): Teacher {
        val obj = teacherRepo.getById(id)
        teacher.subject?.forEach {
            it.teacher = obj
            println("me loop-- ${it.teacher?.name}")
        }
        obj.subject?.retainAll(obj.subject!!)
        obj.subject = teacher.subject
        return teacherRepo.save(obj)
    }

}
