package com.example.reviewcard.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word : Word)

    @Delete
    suspend fun delete(word : Word)

    @Update
    suspend fun update(word: Word)

    @Query("SELECT * FROM words_table")
    fun getAllWords() : LiveData<List<Word>>

    @Query("""
    SELECT 
        *, 
        (1.0 - CAST(correctNum AS REAL) / (repeatNum + 1.0)) * (1.0 / (repeatNum + 1.0)) AS priorityScore
    FROM words_table 
    ORDER BY priorityScore DESC
    """)
    fun getWordsForReview(): LiveData<List<Word>>

}