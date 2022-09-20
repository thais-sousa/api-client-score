package br.com.clientscore.dto

import br.com.clientscore.model.Client
import br.com.clientscore.model.Person
import java.time.LocalDate

data class PostClientRequest(
    val name: String,
    val lastName: String,
    val birthDate: LocalDate,
    val cpf: String,
    val phoneNumber: String,
    val email: String,
    val address: PostAddress
) {
    fun convertToClient(): Client {
        val person = Person(
            name = this.name,
            lastName = this.lastName,
            birthDate = this.birthDate,
            cpf = this.cpf,
            phoneNumber = this.phoneNumber,
            email = this.email,
            address = this.address.convertToAddress()
        )
        return Client(
            person = person,
            currentScore = 0
        )
    }
}
