package br.com.clientscore.repository

import br.com.clientscore.model.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Int> {
    fun existsByCpfOrEmail (cpf: String, email: String): Boolean
}