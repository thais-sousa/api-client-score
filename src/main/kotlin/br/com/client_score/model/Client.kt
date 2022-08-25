package br.com.client_score.model

import java.time.LocalDateTime

data class Client(
    val id: Long,
    val name: String,
    val birthDate: LocalDateTime,
    val cpf: String,
    val email: String,
    val address: Address,
    val score: Score
)
