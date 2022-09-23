package br.com.clientscore.controller

import br.com.clientscore.dto.response.ClientResponse
import br.com.clientscore.dto.request.ClientRequest
import br.com.clientscore.service.ClientService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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
}