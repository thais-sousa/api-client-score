package br.com.clientscore.service

import br.com.clientscore.model.Person
import br.com.clientscore.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
        val personRepository: PersonRepository
) {
    fun create(person: Person): Person {
        return personRepository.save(person)
    }
}