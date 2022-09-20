package br.com.clientscore.dto

import br.com.clientscore.model.Address

class AddressResponse(
        address: Address
) {
    val street = address.street
    val city = address.city
    val state = address.state
}
