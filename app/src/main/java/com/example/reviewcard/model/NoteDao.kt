package com.example.reviewcard.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note : Note)

    @Delete
    suspend fun delete(note: Note)

    @Update
    suspend fun update(note: Note)

    @Query("SELECT * FROM notes_table")
    fun getAllNotes() : LiveData<List<Note>>

    @Query("""
    SELECT 
        *, 
        (1.0 - CAST(correctNum AS REAL) / (repeatNum + 1.0)) * (1.0 / (repeatNum + 1.0)) AS priorityScore
    FROM notes_table 
    ORDER BY priorityScore DESC
    """)
    fun getNotesForReview(): LiveData<List<Note>>

}