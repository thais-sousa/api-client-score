package br.com.clientscore.service

import br.com.clientscore.dto.response.ClientResponse
import br.com.clientscore.exception.NotFoundException
import br.com.clientscore.model.Client
import br.com.clientscore.repository.ClientRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

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

    fun findAll(): List<Client> {
        return clientRepository.findAll()
    }

    fun findById(id: UUID): ClientResponse {
        val client = clientRepository.findById(id).orElseThrow { NotFoundException("O ID - ${id} não existe!") }

        return ClientResponse(client)
    }

    fun findByCpf(cpf: String): ClientResponse {
        val client = clientRepository.findByPersonCpf(cpf).orElseThrow { NotFoundException("O CPF ${cpf} não existe!") }

        return ClientResponse(client)
    }
}