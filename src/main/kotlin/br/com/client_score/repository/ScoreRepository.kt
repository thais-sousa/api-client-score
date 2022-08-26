package br.com.client_score.repository

import br.com.client_score.model.Score
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ScoreRepository : JpaRepository<Score, Int> {
}