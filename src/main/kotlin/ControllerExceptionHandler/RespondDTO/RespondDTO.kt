package ControllerExceptionHandler.RespondDTO

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class RespondDTO(
        val data: Any?,
        val statusCode: Int? = HttpStatus.OK.value(),
        val status: String = HttpStatus.OK.name,
        val message: String? = "",
)

    /**
     * NOTED: JSON respond with standard Http status
     */
    fun HttpStatus.respondJSONFormat(message: String?): ResponseEntity<RespondDTO> {
        return ResponseEntity(RespondDTO(
                data = null,
                status = name,
                statusCode = value(),
                message = message), this
        )
    }


    /**
     * For Custom message and status render JSON Format
     */
    fun renderJSONFormat(data: Any?, statusCode: Int = HttpStatus.OK.value(), message: String? = ""): ResponseEntity<RespondDTO> {
        val status = HttpStatus.valueOf(statusCode)

        return ResponseEntity(
                RespondDTO(data = data, status = status.name, statusCode = statusCode, message = message),
                status
        )
    }