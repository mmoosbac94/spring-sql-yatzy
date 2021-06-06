package com.example.accessingdatamysql

import javax.persistence.*

@Table(name="players")
@Entity
class Player(val name: String,
            @Id @GeneratedValue(strategy= GenerationType.AUTO) var id: Int)

//@Table
//@Entity
//class Player(val name: String,
//           var einser: Int,
//           var zweier: Int,
//           var dreier: Int,
//           var vierer: Int,
//           var fuenfer: Int,
//           var sechser: Int,
//           var summeOben: Int,
//           var bonus: Int,
//           var einPaar: Int,
//           var zweiPaar: Int,
//           var dreiGleiche: Int,
//           var vierGleiche: Int,
//           var kleineStrasse: Int,
//           var grosseStrasse: Int,
//           var vollesHaus: Int,
//           var chance: Int,
//           var yatzy: Int,
//           var endSumme: Int,
//            @Id @GeneratedValue(strategy= GenerationType.AUTO) var id: Int)