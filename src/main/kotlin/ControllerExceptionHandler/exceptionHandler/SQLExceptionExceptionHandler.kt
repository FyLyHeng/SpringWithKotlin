package ControllerExceptionHandler.exceptionHandler

import ControllerExceptionHandler.RespondDTO.RespondDTO
import ControllerExceptionHandler.RespondDTO.respondJSONFormat
import org.hibernate.exception.ConstraintViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import java.sql.SQLIntegrityConstraintViolationException
import java.sql.SQLSyntaxErrorException

open class SQLExceptionExceptionHandler {

    /**
     * Empty exception
     */
    @ExceptionHandler(value = [EmptyResultDataAccessException::class])
    fun handleNotFound(e: EmptyResultDataAccessException): ResponseEntity<RespondDTO> {
        return HttpStatus.NOT_FOUND.respondJSONFormat(e.message.toString())
    }


    @ExceptionHandler(value = [SQLIntegrityConstraintViolationException::class, ConstraintViolationException::class])
    fun handleSQLConstrainException(e: IllegalArgumentException): ResponseEntity<RespondDTO> {
        return HttpStatus.BAD_REQUEST.respondJSONFormat(e.message.toString())
    }


    @ExceptionHandler(value = [IllegalArgumentException::class])
    fun handleSQLIllegalArgumentException(e: IllegalArgumentException): ResponseEntity<RespondDTO> {
        return HttpStatus.BAD_REQUEST.respondJSONFormat(e.message.toString())
    }


    @ExceptionHandler(value = [SQLSyntaxErrorException::class])
    fun handleSQLException(e: SQLSyntaxErrorException): ResponseEntity<RespondDTO> {
        return HttpStatus.INTERNAL_SERVER_ERROR.respondJSONFormat(e.message.toString())
    }
}