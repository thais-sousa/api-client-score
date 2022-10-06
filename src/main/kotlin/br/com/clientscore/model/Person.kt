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
    @JoinColumn(name = "address_id")
    var address: Address,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var lastName: String,

    @Column(nullable = false)
    var birthDate: LocalDate,

    @Column(unique = true, nullable = false)
    val cpf: String,

    @Column(nullable = false)
    var phoneNumber: String,

    @Column(nullable = false)
    var email: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)