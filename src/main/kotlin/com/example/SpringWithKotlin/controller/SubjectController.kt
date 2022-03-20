package com.example.SpringWithKotlin.controller

import ControllerExceptionHandler.RespondDTO.RespondDTO
import ControllerExceptionHandler.RespondDTO.renderJSONFormat
import ControllerExceptionHandler.SimpleGenericRestfulController
import com.example.SpringWithKotlin.model.Subject
import com.example.SpringWithKotlin.model.Teacher
import com.example.SpringWithKotlin.model.repository.StudentRepo
import com.example.SpringWithKotlin.model.repository.SubjectRepo
import com.example.SpringWithKotlin.model.repository.TeacherRepo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional


@RestController
@RequestMapping("/subject")
class SubjectController(val subjectRepo: SubjectRepo, val studentRepo: StudentRepo, val teacherRepo: TeacherRepo) :SimpleGenericRestfulController<Subject>(){

    @PostMapping
    override fun save(@RequestBody resource: Subject): ResponseEntity<RespondDTO> {
        return renderJSONFormat(subjectRepo.save(resource))
    }


    @GetMapping
    override fun getAction(): ResponseEntity<RespondDTO> {
        return renderJSONFormat(subjectRepo.findAll())
    }



    @PutMapping("/assignStudent/{id}")
    fun updateAction(@PathVariable id:Long, @RequestParam studentId:Long):ResponseEntity<RespondDTO>{

        val subject = subjectRepo.getById(id)
        //subject.students.add(studentRepo.getById(studentId))

        val result = subjectRepo.save(subject)

        return renderJSONFormat(result)
    }

    @PutMapping("/assignTeacher/{id}")
    fun assignTeacher(@PathVariable id:Long, @RequestParam teacherId:Long):ResponseEntity<RespondDTO>{
        val subject = subjectRepo.getById(id)

        val teacher = teacherRepo.getById(teacherId)

        subject.teacher = teacher

        val result = subjectRepo.save(subject)

        return renderJSONFormat(result)
    }


    @Transactional
    @PutMapping("/removeStudent/{id}")
    fun removeStudent(@PathVariable id:Long, @RequestParam studentId: List<Long>):ResponseEntity<RespondDTO>{
        val subject = subjectRepo.getById(id)

        val students = studentRepo.findAllById(studentId)

        //subject.students.removeAll(students)

        val result = subjectRepo.save(subject)

        return renderJSONFormat(result)
    }


    /**
     * Remove student to subject
     */
    @Transactional
    @PutMapping("/removeStudent/NativeSQL/{id}")
    fun customerQueryRemoveStudent(@PathVariable id:Long, @RequestParam studentId: List<Long>):ResponseEntity<RespondDTO>{
        subjectRepo.removeStudents(id,studentId)
        val result = subjectRepo.getById(id)
        return renderJSONFormat(result)
    }


    /**
     * this action use for remove teacher form subject
     * By teacherId
     */
    @Transactional
    @PutMapping("/removeTeacherById/{id}")
    fun removeTeacher(@PathVariable id:Long, @RequestParam teacherId: Long):ResponseEntity<RespondDTO>{
        val subject = subjectRepo.getById(id)

        if (teacherRepo.existsById(teacherId)) {
            subject.teacher = null
            val result = subjectRepo.save(subject)
            return renderJSONFormat(result)
        }

        return renderJSONFormat(data = "",message = "Teacher Not Found",statusCode = HttpStatus.NOT_FOUND.value())
    }


    /**
     * this action use for remove teacher by the json body request
     *
     * @subject domain will save follow the json body
     * If the body didn't pass any field -> will be remove.
     */
    @Transactional
    @PutMapping("/removeTeacher/{id}")
    fun removeTeacher(@PathVariable id:Long, @RequestBody subject: Subject):ResponseEntity<RespondDTO>{

        val result = subjectRepo.save(subject)

        return renderJSONFormat(result)
    }
}