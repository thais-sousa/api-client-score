package br.com.clientscore.dto.response

import br.com.clientscore.model.Client

class ClientResponse(client: Client) {
    val id = client.id
    val name = client.person.name
    val lastName = client.person.lastName
    val birthDate = client.person.birthDate
    val cpf = client.person.cpf
    val phoneNumber = client.person.phoneNumber
    val email = client.person.email
    val address = AddressResponse(client.person.address)
}
