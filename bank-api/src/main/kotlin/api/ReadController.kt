package com.jisu.bank.api

import io.swagger.v3.oas.annotations.responses.ApiResponse as SwaggerApiResponse
import io.swagger.v3.oas.annotations.media.Content as SwaggerContent
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/read")
@Tag(name = "Read API", description = "Read operations for bank data")
class ReadController {

    private val  logger = LoggerFactory.getLogger(ReadController::class.java)

    @Operation(
        summary = "Get account details",
        description = "accountNumber api",
        responses = [
            SwaggerApiResponse(
                responseCode = "200",
                description = "Successful retrieval of account details",
                content = [
                    SwaggerContent(
                        mediaType = "application/json",
                        schema = io.swagger.v3.oas.annotations.media.Schema(
                            implementation = String::class // Replace with actual response DTO
                        )
                    )
                ]
            ),
            SwaggerApiResponse(
                responseCode = "404",
                description = "Account not found"
            )
        ]
    )
    @GetMapping("/{accountNumber}")
    fun getAccount(
        @Parameter(description = "Account number", required = true)
        @PathVariable(required = false) accountNumber: String
    ) {
        logger.info("Getting account $accountNumber")
    }

}