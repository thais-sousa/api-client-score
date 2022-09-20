package br.com.clientscore.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Client(

    @Id
    val id: UUID = UUID.randomUUID(),

    @OneToOne
    @JoinColumn(name = "person_id")
    val person: Person,

    val currentScore: Int,

    val createdAt: LocalDateTime = LocalDateTime.now()
)