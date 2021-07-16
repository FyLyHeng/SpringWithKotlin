package ControllerExceptionHandler


interface RestfulControllerImp<T> {

    fun save(resource:T): Any
    fun saved(resource:T): Any
    fun beforeSave(t:T): Any
    fun afterSaved(t:T):Any

    fun getAction(): Any
    fun show():Any
    fun index():Any
}