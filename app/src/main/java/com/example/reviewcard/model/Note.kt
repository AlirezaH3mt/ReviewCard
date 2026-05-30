package com.example.reviewcard.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(

    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val noteTitle : String,
    val description : String,
    val repeatNum : Int,
    val correctNum : Int

)