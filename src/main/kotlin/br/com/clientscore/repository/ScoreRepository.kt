package br.com.clientscore.repository

import br.com.clientscore.model.Score
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ScoreRepository : JpaRepository<Score, Int> {
}