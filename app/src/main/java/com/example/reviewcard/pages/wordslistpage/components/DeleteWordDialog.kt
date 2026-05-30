package com.example.reviewcard.pages.wordslistpage.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reviewcard.R
import com.example.reviewcard.model.Word
import com.example.reviewcard.viewmodel.WordViewModel

@Composable
fun DeleteWordDialog(
    word: Word,
    wordViewModel: WordViewModel,
    showDialog : Boolean,
    onDismiss : () -> Unit
){

    if (showDialog){
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(
                    text = "Delete Word",
                    color = colorResource(R.color.light_red)
                )
            },
            text = {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    Text(
                        text = "Are you sure you want to delete word '${word.wordTitle}'?",
                        fontSize = 18.sp
                    )
                }
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.delete),
                    contentDescription = "Warning Icon.",
                    tint = colorResource(R.color.light_red)
                )
            },
            confirmButton = {
                DeleteWordDialogButtonsTemp(
                    onClick = {
                        wordViewModel.delete(word = word)
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
fun DeleteWordDialogButtonsTemp(
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
