package br.com.client_score.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Person(

    @Id
    val id: UUID = UUID.randomUUID(),

    @OneToOne(mappedBy = "person")
    val client: Client,

    @OneToOne(mappedBy = "person")
    val address: Address,

    val name: String,

    val lastName: String,

    val birthDate: LocalDate,

    @Column(unique = true)
    val cpf: String,

    val phoneNumber: String,

    val email: String,

    val createdAt: LocalDateTime = LocalDateTime.now()
)