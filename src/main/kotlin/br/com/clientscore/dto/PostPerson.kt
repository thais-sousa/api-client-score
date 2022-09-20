package br.com.clientscore.dto

import br.com.clientscore.model.Person
import java.time.LocalDate

class PostPerson(
    private val name: String,
    private val lastName: String,
    private val birthDate: LocalDate,
    private val cpf: String,
    private val phoneNumber: String,
    private val email: String,
    private val address: PostAddress
) {
    fun convertToPerson(): Person {
        return Person(
            name = this.name,
            lastName = this.lastName,
            birthDate = this.birthDate,
            cpf = this.cpf,
            phoneNumber = this.phoneNumber,
            email = this.email,
            address = this.address.convertToAddress()
        )
    }
}
