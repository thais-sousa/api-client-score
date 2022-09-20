package br.com.clientscore.dto

import br.com.clientscore.enums.State
import br.com.clientscore.model.Address

class PostAddress(
    private val street: String,
    private val city: String,
    private val state: State
) {
    fun convertToAddress(): Address {
        return Address(
            street = this.street,
            city = this.city,
            state = this.state
        )
    }
}
