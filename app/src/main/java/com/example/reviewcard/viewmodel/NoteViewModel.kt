package com.example.reviewcard.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reviewcard.model.Note
import com.example.reviewcard.repository.NotesRepository
import kotlinx.coroutines.launch

class NoteViewModel( private val repository: NotesRepository) : ViewModel() {

    val allNotes : LiveData<List<Note>> = repository.allNotes

    val allNotesForReview : LiveData<List<Note>> = repository.allNotesForReview


    fun insert(note: Note){
        viewModelScope.launch {
            repository.insertNote(note = note)
        }
    }

    fun delete(note: Note){
        viewModelScope.launch {
            repository.deleteNote(note = note)
        }
    }

    fun update(note: Note){
        viewModelScope.launch {
            repository.updateNote(note = note)
        }
    }

}