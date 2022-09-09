package br.com.clientscore.model

import br.com.clientscore.enums.State
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Address(

    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val street: String,

    @Column(nullable = false)
    val city: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val state: State,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)