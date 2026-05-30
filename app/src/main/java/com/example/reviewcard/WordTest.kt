package com.example.reviewcard

import com.example.reviewcard.model.Word

class WordTest {
    fun wordTest(): Word{
        val myWord = Word(
            id = 1,
            wordTitle = "AAbandon",
            wordPhonetic = "/əbændən/",
            definition = "1-To leave someone, especially someone you are responsible for.\n" +
                    "2-To go away from a place, vehicle etc permanently, especially because the situation makes it impossible for you to stay." +
                    "asnkcjbs jhdvjshvhbcai au ca ci od asd vkus ha cha ciacnaoiv isi ais ci iduv ai viua iucbs",
            example = "1-How could she abandon her own child?\n" +
                    "2-We had to abandon the car and walk the rest of the way.",
            repeatNum = 1,
            correctNum = 0
        )
        return myWord
    }
}