package br.com.client_score.model

import br.com.client_score.enums.State
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Address(

    @Id
    val id: UUID = UUID.randomUUID(),

    @OneToOne
    @JoinColumn(name = "person_id")
    val person: Person,

    val street: String,

    val city: String,

    @Enumerated(EnumType.STRING)
    val state: State,

    val createdAt: LocalDateTime = LocalDateTime.now()
)