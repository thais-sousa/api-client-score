package br.com.clientscore.service

import br.com.clientscore.dto.request.ClientRequestUpdate
import br.com.clientscore.dto.response.AddressResponse
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

        return convertToClientResponse(clientRepository.save(client))
    }

    fun findAll(): List<ClientResponse> {
        return clientRepository.findAll().map { client ->
            convertToClientResponse(client)
        }.toList()
    }

    fun findClientId(id: UUID): Client {
        return clientRepository.findById(id).orElseThrow { NotFoundException("O ID - ${id} não existe!") }
    }

    fun findClientCpf(cpf: String): Client {
        return clientRepository.findByPersonCpf(cpf).orElseThrow { NotFoundException("O CPF ${cpf} não existe!") }
    }

    fun findById(id: UUID): ClientResponse {
        val client = findClientId(id)

        return convertToClientResponse(client)
    }

    fun findByCpf(cpf: String): ClientResponse {
        val client = findClientCpf(cpf)

        return convertToClientResponse(client)
    }

    fun deleteById(id: UUID) {
        val client = findClientId(id)
        clientRepository.delete(client)
    }

    fun deleteByCpf(cpf: String) {
        val client = findClientCpf(cpf)
        clientRepository.delete(client)
    }

    fun updateById(id: UUID, clientRequest: ClientRequestUpdate) {
        val client = findClientId(id)
        val clientUpdate = clientRequest.updateClient(client)
        clientRepository.save(clientUpdate)
    }

    fun convertToClientResponse(client: Client): ClientResponse {
        return ClientResponse(
            id = client.id,
            name = client.person.name,
            lastName = client.person.lastName,
            birthDate = client.person.birthDate,
            cpf = client.person.cpf,
            phoneNumber = client.person.phoneNumber,
            email = client.person.email,
            address = AddressResponse(client.person.address)
        )
    }


}