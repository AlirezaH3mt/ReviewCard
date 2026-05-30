package com.example.reviewcard.pages.noteslistpage.components

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.reviewcard.model.Note
import com.example.reviewcard.viewmodel.NoteViewModel

@Composable
fun DisplayNotesList(notesList : List<Note>, noteViewModel: NoteViewModel, context: Context){
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
    ){
        items(notesList){
                eachItem -> NotesListItem(note = eachItem, noteViewModel = noteViewModel, context = context)
        }
    }
}