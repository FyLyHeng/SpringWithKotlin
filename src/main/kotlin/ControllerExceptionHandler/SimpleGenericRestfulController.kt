package ControllerExceptionHandler

import ControllerExceptionHandler.RespondDTO.RespondDTO
import ControllerExceptionHandler.exceptionHandler.BaseClassExceptionHandler
import org.springframework.http.ResponseEntity

open class SimpleGenericRestfulController :RestfulControllerImp, BaseClassExceptionHandler() {


    override fun save(): ResponseEntity<RespondDTO> {
        TODO("Not yet implemented")
    }

    override fun getAction(): ResponseEntity<RespondDTO> {
        TODO("Not yet implemented")
    }

    override fun show(): Any {
        TODO("Not yet implemented")
    }

    override fun index(): Any {
        TODO("Not yet implemented")
    }

    override fun beforeSave(): ResponseEntity<RespondDTO> {
        TODO("Not yet implemented")
    }

    override fun afterSaved(): Any {
        TODO("Not yet implemented")
    }

}