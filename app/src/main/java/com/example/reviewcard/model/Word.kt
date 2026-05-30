package com.example.reviewcard.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class Word (

    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,

    val wordTitle : String,
    val wordPhonetic : String,
    val definition : String,
    val example : String,
    val repeatNum : Int,
    val correctNum : Int

)