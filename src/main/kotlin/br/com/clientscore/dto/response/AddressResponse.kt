package br.com.clientscore.dto.response

import br.com.clientscore.model.Address

class AddressResponse(
    address: Address
) {
    val street = address.street
    val city = address.city
    val state = address.state
}
