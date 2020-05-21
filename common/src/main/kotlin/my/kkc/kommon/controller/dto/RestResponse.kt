package my.kkc.kommon.controller.dto


open class RestResponse(val success: Boolean)

data class ErrorResponse(val message: String? = null): RestResponse(false)

data class SuccessResponse<T>(val payload: T): RestResponse(true)
