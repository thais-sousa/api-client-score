package br.com.clientscore.model

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Person(

    @Id
    val id: UUID = UUID.randomUUID(),

    @OneToOne
    @JoinColumn(name="address_id")
    val address: Address,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val lastName: String,

    @Column(nullable = false)
    val birthDate: LocalDate,

    @Column(unique = true, nullable = false)
    val cpf: String,

    @Column(nullable = false)
    val phoneNumber: String,

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)