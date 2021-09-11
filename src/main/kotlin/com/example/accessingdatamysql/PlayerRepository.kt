package com.example.accessingdatamysql

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PlayerRepository: JpaRepository<Player, Int> {
    fun findByName(name: String): Optional<Player>
}