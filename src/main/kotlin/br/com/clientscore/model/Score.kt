package br.com.clientscore.model

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Score(

    @Id
    val id: UUID = UUID.randomUUID(),

    @OneToOne
    @JoinColumn(name = "client_id")
    val client: Client,

    @Column(nullable = false)
    val consultedDate: LocalDateTime,

    @Column(nullable = false)
    val score: Int,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)