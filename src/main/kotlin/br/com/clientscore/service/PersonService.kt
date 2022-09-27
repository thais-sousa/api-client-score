package br.com.clientscore.service

import br.com.clientscore.exception.UnprocessableException
import br.com.clientscore.model.Person
import br.com.clientscore.repository.PersonRepository
import org.hibernate.validator.constraints.br.CPF
import org.springframework.stereotype.Service

@Service
class PersonService(
    val personRepository: PersonRepository
) {

    fun existisByCpfOrEmail(cpf: String, email: String) {
        val isExist = personRepository.existsByCpfOrEmail(cpf,email)

        if (isExist) {
            throw UnprocessableException("O CPF ou e-mail informado já existe!")
        }
    }

    fun create(person: Person): Person {
        return personRepository.save(person)
    }
}