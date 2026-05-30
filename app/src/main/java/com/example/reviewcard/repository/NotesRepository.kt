package com.example.reviewcard.repository

import androidx.lifecycle.LiveData
import com.example.reviewcard.model.Note
import com.example.reviewcard.model.NoteDao


class NotesRepository( private val noteDao: NoteDao) {

    val allNotes : LiveData<List<Note>> = noteDao.getAllNotes()
    val allNotesForReview : LiveData<List<Note>> = noteDao.getNotesForReview()
    suspend fun insertNote(note: Note){
        return noteDao.insert(note = note)
    }

    suspend fun deleteNote(note: Note){
        return noteDao.delete(note = note)
    }

    suspend fun updateNote(note: Note){
        return noteDao.update(note = note)
    }

}