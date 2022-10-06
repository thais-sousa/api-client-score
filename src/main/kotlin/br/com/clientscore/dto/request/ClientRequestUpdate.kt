package br.com.clientscore.dto.request

import br.com.clientscore.model.Client
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class ClientRequestUpdate(

    @field:NotEmpty(message = "O nome deve ser informado!")
    var name: String,

    @field:NotEmpty(message = "O sobrenome deve ser informado!")
    var lastName: String,

    @field:NotNull(message = "A data deve ser preenchida no formato dd/mm/aaaa")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "pt-BR")
    var birthDate: LocalDate,

    @field:Size(min = 11, max = 11)
    var phoneNumber: String,

    @field:NotEmpty
    @field:Email(message = "O e-mail deve ser válido!")
    var email: String,

    @field:Valid
    var address: AddressRequest
) {
    fun updateClient(client: Client): Client {
        val address = address.updateAddress(client.person.address)//atualizando
        client.person.name = this.name
        client.person.lastName = this.lastName
        client.person.birthDate = this.birthDate
        client.person.phoneNumber = this.phoneNumber
        client.person.email = this.email
        client.person.address = address

        return client
    }

}
//) {
//    fun convertToClient(): Client {
//        val person = Person(
//            name = this.name,
//            lastName = this.lastName,
//            birthDate = this.birthDate,
//            phoneNumber = this.phoneNumber,
//            email = this.email,
//            address = this.address.convertToAddress()
//        )
//        return Client(
//            person = person,
//        )
//    }
//}
