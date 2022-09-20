package br.com.clientscore.service

import br.com.clientscore.dto.ClientResponse
import br.com.clientscore.model.Client
import br.com.clientscore.repository.ClientRepository
import org.springframework.stereotype.Service

@Service
class ClientService(
        val clientRepository: ClientRepository,
        val addressService: AddressService,
        val personService: PersonService
) {

    fun create(client: Client): ClientResponse {
        addressService.create(client.person.address)
        personService.create(client.person)

        val client = clientRepository.save(client)

        return ClientResponse(client)
    }
}