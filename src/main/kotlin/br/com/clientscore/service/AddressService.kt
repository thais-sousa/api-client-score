package br.com.clientscore.service

import br.com.clientscore.model.Address
import br.com.clientscore.repository.AddressRepository
import org.springframework.stereotype.Service

@Service
class AddressService(
    val addressRepository: AddressRepository
) {
    fun create(address: Address): Address {
        return addressRepository.save(address)
    }
}