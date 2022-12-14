package br.com.clientscore.controller

import br.com.clientscore.dto.request.ClientRequest
import br.com.clientscore.dto.request.ClientRequestUpdate
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

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID): ResponseEntity<Unit> {
        clientService.deleteById(id)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

    @DeleteMapping("/cpf")
    fun deleteByCpf(@RequestHeader cpf: String): ResponseEntity<Unit> {
        clientService.deleteByCpf(cpf)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: UUID, @RequestBody @Valid client: ClientRequestUpdate): ResponseEntity<Unit> {
        clientService.updateById(id, client)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

    @PutMapping("/cpf")
    fun updateByCpf(@RequestHeader cpf: String, @RequestBody @Valid client: ClientRequestUpdate): ResponseEntity<Unit> {
        clientService.updateByCpf(cpf, client)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}