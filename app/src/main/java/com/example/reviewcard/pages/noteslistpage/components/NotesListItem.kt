package com.example.reviewcard.pages.noteslistpage.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reviewcard.R
import com.example.reviewcard.model.Note
import com.example.reviewcard.viewmodel.NoteViewModel

@Composable
fun NotesListItem(note: Note, noteViewModel: NoteViewModel, context: Context){

    var showDialog by remember {
        mutableStateOf(false)
    }

    var showEditDialog by remember {
        mutableStateOf(false)
    }

    DeleteNoteDialog(
        note = note,
        noteViewModel = noteViewModel,
        showDialog = showDialog,
        onDismiss = {showDialog = false}
    )

    EditNoteDialog(
        note = note,
        noteViewModel = noteViewModel,
        showDialog = showEditDialog,
        onDismiss = {showEditDialog = false},
        context = context
    )

    Card (
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.super_light_blue)),
        modifier = Modifier
            .padding(12.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = note.noteTitle,
                    fontSize = 18.sp,
                    color = colorResource(R.color.black),
                    fontWeight = FontWeight.SemiBold
                )

            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        showEditDialog = true
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.edit),
                        contentDescription = "Edit note"
                    )
                }

                IconButton(
                    onClick = {
                        showDialog = true
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.delete),
                        contentDescription = "Delete Icon"
                    )
                }
            }

        }
    }
}