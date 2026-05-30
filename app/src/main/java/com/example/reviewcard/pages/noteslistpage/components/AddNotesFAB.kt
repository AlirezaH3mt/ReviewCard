package com.example.reviewcard.pages.noteslistpage.components

import android.content.Context
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.reviewcard.R
import com.example.reviewcard.viewmodel.NoteViewModel

@Composable
fun AddNotesFAB(noteViewModel: NoteViewModel, context: Context){

    var showDialog by remember {
        mutableStateOf(false)
    }

    AddNoteDialog(
        noteViewModel = noteViewModel,
        showDialog = showDialog,
        onDismiss = { showDialog = false},
        context = context
    )

    FloatingActionButton(
        onClick = { showDialog = true },
        containerColor = colorResource(R.color.dirty_green),
        contentColor = colorResource(R.color.black)
    ) {
        Icon(
            painter = painterResource(R.drawable.add),
            contentDescription = "Add Note"
        )
    }

}