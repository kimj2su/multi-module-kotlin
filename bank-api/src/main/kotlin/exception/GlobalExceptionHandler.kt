package com.jisu.bank.exception

import com.jisu.bank.common.ApiResponse
import com.jisu.bank.core.exception.AccountNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalExceptionHandler{
    private val logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    fun handleAccountNotFound(
        ex: AccountNotFoundException,
        req: WebRequest
    ): ResponseEntity<ApiResponse<T>> {
        logger.error("Account not found: ${ex.message}", ex)
        val response = ApiResponse.exceptionError<Nothing>(
            msg = ex.message ?: "Account not found",
            errCode = "ACCOUNT_NOT_FOUND",
//            details = ex.localizedMessage,
            path = getPath(req)
        )

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response)
    }

    private fun getPath(req: WebRequest): String? {
        return req.getDescription(false).removePrefix("uri=").takeIf { it.isNotBlank() }
    }

}