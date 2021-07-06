package ControllerExceptionHandler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import java.io.IOException
import java.sql.SQLIntegrityConstraintViolationException
import java.sql.SQLSyntaxErrorException

open class BaseClassHandler {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e:NoSuchElementException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBedRequest(e:IllegalArgumentException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(IOException::class)
    fun handleIO(e: IOException): ResponseEntity<String> {
        return ResponseEntity(e.message, HttpStatus.BAD_GATEWAY)
    }

    @ExceptionHandler(SQLSyntaxErrorException::class)
    fun handleSQLException(e:SQLSyntaxErrorException):ResponseEntity<String>{
        return ResponseEntity(e.message,HttpStatus.BAD_GATEWAY)
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException::class)
    fun handleSQLValidFieldException(e: SQLIntegrityConstraintViolationException): ResponseEntity<RespondDTO> {
        return ResponseEntity(
                RespondDTO(
                        data = null,
                        status = HttpStatus.BAD_REQUEST.name,
                        statusCode = HttpStatus.BAD_GATEWAY.value(),
                        message = e.message.toString()
                ),
                HttpStatus.BAD_REQUEST
        )
    }

    fun renderJSONFormat(data:Any?,statusCode:Int=HttpStatus.OK.value(),message:String?=""):ResponseEntity<RespondDTO>{
        val status = HttpStatus.valueOf(statusCode)


        return ResponseEntity(RespondDTO(
                data =data,
                status = status.name,
                statusCode = statusCode,
                message = message), status
        )
    }
}

class RespondDTO(
        val data: Any?,
        val statusCode: Int? = HttpStatus.OK.value(),
        val status: String = HttpStatus.OK.name,
        val message: String? = "",
        )