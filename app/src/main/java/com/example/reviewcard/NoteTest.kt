package com.example.reviewcard

import com.example.reviewcard.model.Note

class NoteTest {
    fun noteTest() : Note{
        val myNote = Note(
            id = 0,
            noteTitle = "Alireza",
            description = "Hey you should remember that you are amazing!",
            repeatNum = 1,
            correctNum = 0
        )
        return myNote
    }
}