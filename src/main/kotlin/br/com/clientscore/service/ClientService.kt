package br.com.clientscore.service

import br.com.clientscore.dto.response.ClientResponse
import br.com.clientscore.model.Client
import br.com.clientscore.repository.ClientRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ClientService(
    val clientRepository: ClientRepository,
    val addressService: AddressService,
    val personService: PersonService
) {

    @Transactional
    fun create(client: Client): ClientResponse {
        personService.existisByCpfOrEmail(client.person.cpf, client.person.email)
        addressService.create(client.person.address)
        personService.create(client.person)

        val client = clientRepository.save(client)

        return ClientResponse(client)
    }
}