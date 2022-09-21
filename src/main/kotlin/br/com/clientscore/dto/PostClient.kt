package br.com.clientscore.dto

import br.com.clientscore.model.Client
import br.com.clientscore.model.Person
import com.fasterxml.jackson.annotation.JsonFormat
import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class PostClient(

    @field:NotEmpty(message = "O nome deve ser informado!")
    val name: String,

    @field:NotEmpty(message = "O sobrenome deve ser informado!")
    val lastName: String,

    @field:NotNull(message = "A data deve ser preenchida no formato dd/mm/aaaa")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR")
    val birthDate: LocalDate,

    @field:CPF
    val cpf: String,

    @field:Size(min = 11, max = 11)
    val phoneNumber: String,

    @field:NotEmpty
    @field:Email(message = "O e-mail deve ser válido!")
    val email: String,

    @field:Valid
    val address: PostAddress
) {
    fun convertToClient(): Client {
        val person = Person(
            name = this.name,
            lastName = this.lastName,
            birthDate = this.birthDate!!,
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
