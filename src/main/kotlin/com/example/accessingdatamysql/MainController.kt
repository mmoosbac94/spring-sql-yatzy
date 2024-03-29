package com.example.accessingdatamysql

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin
@RestController
@RequestMapping(path = ["/api"])
class MainController {

    @Autowired
    private lateinit var playerRepository: PlayerRepository

//    @RequestMapping(path = ["/add"], method = [RequestMethod.POST])
//    fun addNewPlayer(@RequestBody player: Player) : Player {
//        return playerRepository.save(player)
//    }


    @RequestMapping(path = ["/update"], method = [RequestMethod.PUT])
    fun updatePlayerByName(@RequestBody players: List<Player>): ResponseEntity<Player?> {
        

        var updatedPlayer: Player? = null
        players.forEach { player ->
            val playerResult: Optional<Player> = playerRepository.findByName(player.name)
            if (!playerResult.isPresent) {
                playerRepository.save(player)
            } else {
                playerResult.get().wins += player.wins
                if(playerResult.get().maxendSum < player.maxendSum) {
                    playerResult.get().maxendSum = player.maxendSum
                }
                updatedPlayer = playerRepository.save(playerResult.get())
            }
        }
        return ResponseEntity.ok(updatedPlayer)
    }

    @RequestMapping(path = ["/highscore"], method = [RequestMethod.GET])
    fun getHighScore(): Int {
        val players = getAllPlayers()
        return if(players.toList().isEmpty()) {
            0
        } else {
            players.maxOf { it.maxendSum }
        }
    }

    @RequestMapping(path = ["/all"], method = [RequestMethod.GET])
    fun getAllPlayers(): MutableIterable<Player> {
        return playerRepository.findAll()
    }


}