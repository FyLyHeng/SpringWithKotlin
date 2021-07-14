package ControllerExceptionHandler.exceptionHandler

import ControllerExceptionHandler.RespondDTO.RespondDTO
import ControllerExceptionHandler.RespondDTO.respondJSONFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import java.io.IOException
import javax.persistence.EntityNotFoundException

abstract class BaseClassExceptionHandler :SQLExceptionExceptionHandler(){

    @ExceptionHandler(value = [NoSuchElementException::class])
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<RespondDTO> {
        return HttpStatus.NOT_FOUND.respondJSONFormat(e.message.toString())
    }

    @ExceptionHandler(value = [EntityNotFoundException::class])
    fun handleNotFound(e: EntityNotFoundException): ResponseEntity<RespondDTO> {
        return HttpStatus.NOT_FOUND.respondJSONFormat(e.message.toString())
    }


    @ExceptionHandler(value = [IOException::class])
    fun handleIO(e: IOException): ResponseEntity<RespondDTO> {
        return HttpStatus.BAD_REQUEST.respondJSONFormat(e.message.toString())
    }




}
