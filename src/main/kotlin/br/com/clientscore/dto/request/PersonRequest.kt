package br.com.clientscore.dto.request

import br.com.clientscore.model.Person
import java.time.LocalDate

class PersonRequest(
    private val name: String,
    private val lastName: String,
    private val birthDate: LocalDate,
    private val phoneNumber: String,
    private val email: String,
    private val address: AddressRequest
)
