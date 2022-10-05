package br.com.clientscore.dto.response

import java.time.LocalDate
import java.util.*

class ClientResponse(
    val id: UUID,
    val name: String,
    val lastName: String,
    val birthDate: LocalDate,
    val cpf: String,
    val phoneNumber: String,
    val email: String,
    val address: AddressResponse
)
