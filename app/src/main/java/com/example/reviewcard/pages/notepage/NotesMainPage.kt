package com.example.reviewcard.pages.notepage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.reviewcard.NoteTest
import com.example.reviewcard.R
import com.example.reviewcard.model.Note
import com.example.reviewcard.pages.BottomAppBarTemp
import com.example.reviewcard.pages.TopAppBarTemp
import com.example.reviewcard.pages.notepage.components.InfoCard
import com.example.reviewcard.pages.notepage.components.NoteDisplayCard
import com.example.reviewcard.pages.notepage.components.NotePageButtons
import com.example.reviewcard.pages.wordpage.components.WordPageButtons
import com.example.reviewcard.viewmodel.NoteViewModel


@Composable
fun NotesMainPage(navController: NavController, noteViewModel: NoteViewModel, notesListForReview : List<Note>){

    var itemIndex by remember {
        mutableIntStateOf(0)
    }

    var notesListMut by remember {
        mutableStateOf(notesListForReview)
    }

    var isNewCard by remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBarTemp(barTitle = "Review Notes", navController = navController) },
        containerColor = colorResource(R.color.dark_gray)
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            if(notesListMut.isNotEmpty() && itemIndex in notesListMut.indices){
                val currentNote = notesListMut[itemIndex]
                InfoCard(note = currentNote)
                NoteDisplayCard(note = currentNote, isNewCard = isNewCard)

                WordPageButtons(
                    onRightClick = {
                        isNewCard = true
                        val updatedNote = currentNote.copy(
                            repeatNum = currentNote.repeatNum + 1,
                            correctNum = currentNote.correctNum + 1
                        )
                        noteViewModel.update(updatedNote)
                        // Correctly updates itemIndex, triggering recomposition
                        if (itemIndex < notesListForReview.size - 1) {
                            itemIndex += 1
                        }
                        else{
                            itemIndex = 0
                        }
                    },
                    onWrongClick = {
                        isNewCard = true
                        val updatedNote = currentNote.copy(
                            repeatNum = currentNote.repeatNum + 1,
                            // Note: correctNum does NOT change on wrong answer
                        )
                        noteViewModel.update(updatedNote)
                        if (itemIndex < notesListForReview.size - 1){
                            itemIndex += 1
                        }
                        else{
                            itemIndex = 0
                        }
                    }
                )

            }
            else {
                // Display a message when the list is empty or review is complete
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(
                        text = "No notes for review or list is empty.",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.white),
                        modifier = Modifier.padding(16.dp)
                    )
                }

            }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun NotesMainPagePreview(){
    //NotesMainPage()
}














