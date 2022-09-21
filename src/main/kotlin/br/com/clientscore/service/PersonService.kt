package br.com.clientscore.service

import br.com.clientscore.exception.UnprocessableException
import br.com.clientscore.model.Person
import br.com.clientscore.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(
        val personRepository: PersonRepository
) {
    fun create(person: Person): Person {
        val isExist = personRepository.existsByCpfOrEmail(person.cpf, person.email)

        if(isExist) {
            throw UnprocessableException("O CPF ou e-mail informado já existe!")
        }
        return personRepository.save(person)
    }
}