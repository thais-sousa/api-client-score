package br.com.client_score.model

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
data class Score(

    @Id
    val id: UUID = UUID.randomUUID(),

    @OneToOne
    @JoinColumn(name = "client_id")
    val client: Client,

    val consultedDate: LocalDateTime,

    val score: Integer,

    val createdAt: LocalDateTime = LocalDateTime.now()
)