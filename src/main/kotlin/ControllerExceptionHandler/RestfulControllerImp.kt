package ControllerExceptionHandler

interface RestfulControllerImp {

    fun save(): Any
    fun beforeSave(): Any
    fun afterSaved():Any

    fun getAction(): Any
    fun show():Any
    fun index():Any
}