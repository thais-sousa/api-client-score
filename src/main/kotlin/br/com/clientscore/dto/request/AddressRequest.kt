package br.com.clientscore.dto.request

import br.com.clientscore.enums.State
import br.com.clientscore.model.Address
import javax.validation.constraints.NotBlank

class AddressRequest(

    @field:NotBlank
    private val street: String,

    @field:NotBlank
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

    fun updateAddress(address: Address): Address {
        address.street = this.street
        address.city = this.city
        address.state = this.state

        return address
    }
}
