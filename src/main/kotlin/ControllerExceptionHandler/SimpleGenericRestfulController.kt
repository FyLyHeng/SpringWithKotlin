package ControllerExceptionHandler

import ControllerExceptionHandler.RespondDTO.RespondDTO
import ControllerExceptionHandler.RespondDTO.renderJSONFormat
import ControllerExceptionHandler.exceptionHandler.BaseClassExceptionImp
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

abstract class SimpleGenericRestfulController<T> : RestfulControllerImp<T>, BaseClassExceptionImp() {

    override fun save(resource: T): ResponseEntity<RespondDTO> {
        TODO("Not yet implemented")
    }

    override fun saved(resource:T): ResponseEntity<RespondDTO>{
        return renderJSONFormat(resource)
    }

    override fun beforeSave(t: T): ResponseEntity<RespondDTO> {
        TODO("Not yet implemented")
    }

    override fun afterSaved(t: T): ResponseEntity<RespondDTO> {
        TODO("Not yet implemented")
    }

    override fun getAction(): ResponseEntity<RespondDTO> {
        TODO("Not yet implemented")
    }

    override fun show(): ResponseEntity<RespondDTO> {
        TODO("Not yet implemented")
    }

    override fun index(): ResponseEntity<RespondDTO> {
        TODO("Not yet implemented")
    }

}