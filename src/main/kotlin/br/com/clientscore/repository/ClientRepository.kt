package br.com.clientscore.repository

import br.com.clientscore.model.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClientRepository : JpaRepository<Client, Int> {
    fun findById(id: UUID): Optional<Client>

    fun findByPersonCpf(cpf: String): Optional<Client>
}