package com.example.reviewcard.pages.wordslistpage.components

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
import com.example.reviewcard.viewmodel.WordViewModel

@Composable
fun AddWordFAB(
    wordViewModel: WordViewModel,
    context: Context
){

    var showAddWordDialog by remember {
        mutableStateOf(false)
    }

    AddWordDialog(
        wordViewModel = wordViewModel,
        showDialog = showAddWordDialog,
        onDismiss = {showAddWordDialog = false},
        context = context
    )


    FloatingActionButton(
        onClick = { showAddWordDialog = true },
        containerColor = colorResource(R.color.dirty_green),
        contentColor = colorResource(R.color.black)
    ) {
        Icon(
            painter = painterResource(R.drawable.add),
            contentDescription = "Add Word"
        )
    }
}