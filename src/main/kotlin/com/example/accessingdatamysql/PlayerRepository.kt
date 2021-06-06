package com.example.accessingdatamysql

import org.springframework.data.jpa.repository.JpaRepository

interface PlayerRepository: JpaRepository<Player, Int>