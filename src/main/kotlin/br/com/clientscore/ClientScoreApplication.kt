package br.com.clientscore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ClientScoreApplication

fun main(args: Array<String>) {
	runApplication<ClientScoreApplication>(*args)
}
