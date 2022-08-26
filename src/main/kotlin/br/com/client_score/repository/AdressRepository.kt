package br.com.client_score.repository

import br.com.client_score.model.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AdressRepository : JpaRepository<Address, Int> {
}