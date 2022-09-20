package br.com.clientscore.repository

import br.com.clientscore.model.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository : JpaRepository<Address, Int>{
}