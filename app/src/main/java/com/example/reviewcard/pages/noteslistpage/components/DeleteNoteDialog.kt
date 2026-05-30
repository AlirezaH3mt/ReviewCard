package com.example.reviewcard.pages.noteslistpage.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reviewcard.R
import com.example.reviewcard.model.Note
import com.example.reviewcard.pages.wordslistpage.components.DeleteWordDialogButtonsTemp
import com.example.reviewcard.viewmodel.NoteViewModel


@Composable
fun DeleteNoteDialog(
    note: Note,
    noteViewModel: NoteViewModel,
    showDialog : Boolean,
    onDismiss : () -> Unit
){
    if (showDialog){
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(
                    text = "Delete Note",
                    color = colorResource(R.color.light_red)
                )
            },
            text = {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Text(
                        text = "Are you sure you want to delete note '${note.noteTitle}'?",
                        fontSize = 18.sp
                    )
                }
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.warning),
                    contentDescription = "Warning Icon.",
                    tint = colorResource(R.color.light_red)
                )
            },
            confirmButton = {
                DeleteWordDialogButtonsTemp(
                    onClick = {
                        noteViewModel.delete(note = note)
                        onDismiss()
                    },
                    btnText = "Delete",
                    btnColor = R.color.light_red,
                    btnTextColor = R.color.white
                )
            },
            dismissButton = {
                DeleteWordDialogButtonsTemp(
                    onClick = onDismiss,
                    btnText = "Cancel",
                    btnColor = R.color.dark_gray,
                    btnTextColor = R.color.white
                )
            }
        )
    }

}



@Composable
fun DeleteNoteDialogButtonsTemp(
    onClick : () -> Unit,
    btnText : String,
    btnColor : Int,
    btnTextColor : Int
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(100.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(btnColor)
        )
    ) {
        Text(
            text = btnText,
            color = colorResource(btnTextColor)
        )
    }
}