package com.example.reviewcard.pages.noteslistpage.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.reviewcard.R
import com.example.reviewcard.model.Note
import com.example.reviewcard.pages.wordslistpage.components.AddWordDialogButtonsTemp
import com.example.reviewcard.viewmodel.NoteViewModel


@Composable
fun EditNoteDialog(
    note: Note,
    noteViewModel: NoteViewModel,
    showDialog : Boolean,
    onDismiss : () -> Unit,
    context: Context
){
    var newNoteTitle by remember {
        mutableStateOf(note.noteTitle)
    }

    var newNoteDescription by remember {
        mutableStateOf(note.description)
    }


    if (showDialog){
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(
                    text = "Edit Note '${note.id}'",
                    color = colorResource(R.color.black)
                )
            },
            text = {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    TextField(
                        value = newNoteTitle,
                        onValueChange = { newNoteTitle = it},
                        label = {
                            Text(
                                text = "Note Title:"
                            )
                        },
                        modifier = Modifier
                            .padding(12.dp),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = colorResource(R.color.dirty_green),
                            unfocusedIndicatorColor = colorResource(R.color.transparent),
                            focusedContainerColor = colorResource(R.color.dark_gray),
                            unfocusedContainerColor = colorResource(R.color.dark_gray),
                            focusedTextColor = colorResource(R.color.white),
                            unfocusedTextColor = colorResource(R.color.white),
                            focusedLabelColor = colorResource(R.color.white),
                            unfocusedLabelColor = colorResource(R.color.white)
                        ),
                        maxLines = 4
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    TextField(
                        value = newNoteDescription,
                        onValueChange = { newNoteDescription = it},
                        label = {
                            Text(
                                text = "Note Description:"
                            )
                        },
                        modifier = Modifier
                            .padding(12.dp),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = colorResource(R.color.dirty_green),
                            unfocusedIndicatorColor = colorResource(R.color.transparent),
                            focusedContainerColor = colorResource(R.color.dark_gray),
                            unfocusedContainerColor = colorResource(R.color.dark_gray),
                            focusedTextColor = colorResource(R.color.white),
                            unfocusedTextColor = colorResource(R.color.white),
                            focusedLabelColor = colorResource(R.color.white),
                            unfocusedLabelColor = colorResource(R.color.white)
                        ),
                        maxLines = 4
                    )
                }
            },
            confirmButton = {
                AddNoteDialogButtonsTemp(
                    onClick = {
                        val newNote = Note(
                            id = note.id,
                            noteTitle = newNoteTitle,
                            description = newNoteDescription,
                            repeatNum = note.repeatNum,
                            correctNum = note.correctNum
                        )
                        if(newNoteTitle.isNotEmpty() and newNoteDescription.isNotEmpty()){
                            noteViewModel.update(note = newNote)
                            onDismiss()
                        }else{
                            Toast.makeText(context, "Fill all the fields please!", Toast.LENGTH_LONG).show()
                        }

                    },
                    btnText = "Edit",
                    btnColor = R.color.green,
                    btnTextColor = R.color.white
                )
            },
            dismissButton = {
                newNoteTitle = note.noteTitle
                newNoteDescription = note.description
                AddWordDialogButtonsTemp(
                    onClick = onDismiss,
                    btnText = "Cancel",
                    btnColor = R.color.light_red,
                    btnTextColor = R.color.white
                )
            },
            containerColor = colorResource(R.color.super_light_blue)
        )
    }

}