package br.com.clientscore.exception

data class ErrorResponse(
    val httpCode: Int,
    val message: String?
)