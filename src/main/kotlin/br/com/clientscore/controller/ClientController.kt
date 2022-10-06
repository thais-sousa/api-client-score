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
    fun findAll(): ResponseEntity<List<ClientResponse>> {
        val client = clientService.findAll()
        return ResponseEntity.status(HttpStatus.OK).body(client)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): ResponseEntity<ClientResponse> {
        val client = clientService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(client)
    }

    @GetMapping("/cpf")
    fun findByCpf(@RequestHeader cpf: String): ResponseEntity<ClientResponse> {
        val client = clientService.findByCpf(cpf)
        return ResponseEntity.status(HttpStatus.OK).body(client)
    }
}