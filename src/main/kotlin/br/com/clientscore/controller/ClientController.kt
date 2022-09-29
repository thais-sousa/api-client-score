package br.com.clientscore.controller

import br.com.clientscore.dto.request.ClientRequest
import br.com.clientscore.dto.response.ClientResponse
import br.com.clientscore.model.Client
import br.com.clientscore.service.ClientService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/clients")
class ClientController(
    val clientService: ClientService,
) {

    @PostMapping
    fun create(@RequestBody @Valid client: ClientRequest): ResponseEntity<ClientResponse> {
        val client = clientService.create(client.convertToClient())
        return ResponseEntity.status(HttpStatus.CREATED).body(client)
    }

    @GetMapping
    fun findAll(): List<Client> {
        return clientService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ClientResponse {
        return clientService.findById(id)
    }

    @GetMapping("/cpf")
    fun findByCpf(@RequestHeader cpf: String): ClientResponse {
        return clientService.findByCpf(cpf)
    }
}