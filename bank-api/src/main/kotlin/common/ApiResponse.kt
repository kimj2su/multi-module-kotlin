package com.jisu.bank.common

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.ResponseEntity

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ApiResponse<T>(
    val sucess: Boolean,
    val message: String,
    val data: T? = null,
    val error: Error? = null
) {
    companion object {
        fun <T> success(data: T, msg: String = "Success"): ResponseEntity<ApiResponse<T>> {
            return ResponseEntity.ok(ApiResponse(true, msg, data))
        }

        fun <T> error(
            msg: String,
            errCode: String? = null,
            details: Any? = null,
            path : String? = null
        ) : ResponseEntity<ApiResponse<T>> {
            return ResponseEntity.badRequest().body(
                ApiResponse(
                    sucess = false,
                    message = msg,
                    data = null,
                    Error(code = errCode, details = details, path = path)
                )
            )
        }

        fun <T> exceptionError(
            msg: String,
            errCode: String? = null,
            details: Any? = null,
            path: String? = null
        ) : ApiResponse<T> {
            return ApiResponse(
                sucess = false,
                message = msg,
                data = null,
                error = Error(code = errCode, details = details, path = path)
            )
        }
    }
}

data class Error(
    val code: String? = null,
    val details : Any? = null,
    val path: String? = null,
)