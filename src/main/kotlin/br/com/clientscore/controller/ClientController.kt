package br.com.clientscore.controller

import br.com.clientscore.dto.request.ClientRequest
import br.com.clientscore.dto.response.ClientResponse
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
    fun findAll(): List<ClientResponse> {
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

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID) {
        clientService.deleteById(id)
    }

    @DeleteMapping("/cpf")
    fun deleteByCpf(@RequestHeader cpf: String) {
        clientService.deleteByCpf(cpf)
    }
}