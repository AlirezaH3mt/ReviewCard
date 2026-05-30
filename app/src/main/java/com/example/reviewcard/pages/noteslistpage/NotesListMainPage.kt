package com.example.reviewcard.pages.noteslistpage

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.example.reviewcard.R
import com.example.reviewcard.model.Note
import com.example.reviewcard.pages.BottomAppBarTemp
import com.example.reviewcard.pages.TopAppBarTemp
import com.example.reviewcard.pages.noteslistpage.components.AddNotesFAB
import com.example.reviewcard.pages.noteslistpage.components.DisplayNotesList
import com.example.reviewcard.pages.noteslistpage.components.NotesListTAB
import com.example.reviewcard.viewmodel.NoteViewModel


@Composable
fun NotesListMainPage(
    noteViewModel: NoteViewModel,
    notesList : List<Note>,
    navController: NavController,
    context: Context
){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { NotesListTAB(barTitle = "Notes List", navController = navController, noteViewModel = noteViewModel, context = context) },
        bottomBar = { BottomAppBarTemp(navController = navController) },
        //floatingActionButton = { AddNotesFAB(noteViewModel = noteViewModel , context = context) },
        containerColor = colorResource(R.color.dark_gray)
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            DisplayNotesList(notesList = notesList, noteViewModel = noteViewModel, context = context)
        }

    }
}