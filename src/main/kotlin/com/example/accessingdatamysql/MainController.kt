package com.example.accessingdatamysql

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/api"])
class MainController {

    @Autowired
    private lateinit var playerRepository: PlayerRepository

    @RequestMapping(path = ["/add"], method = [RequestMethod.POST])
    fun addNewUser(@RequestBody player: Player) : Player {
        return playerRepository.save(player)
    }

    @RequestMapping(path = ["/all"], method = [RequestMethod.GET])
    fun getAllUsers(): MutableIterable<Player> {
        return playerRepository.findAll()
    }


}