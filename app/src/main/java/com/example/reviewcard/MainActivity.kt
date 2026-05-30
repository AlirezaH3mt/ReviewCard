package com.example.reviewcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.reviewcard.defaultdata.AddDefaultData
import com.example.reviewcard.model.WordsNotesDB
import com.example.reviewcard.navigation.NavGraph
import com.example.reviewcard.pages.welcomepage.WelcomeMainPage
import com.example.reviewcard.pages.wordslistpage.WordsListMainPage
import com.example.reviewcard.repository.NotesRepository
import com.example.reviewcard.repository.WordsRepository
import com.example.reviewcard.ui.theme.ReviewCardTheme
import com.example.reviewcard.viewmodel.NoteViewModel
import com.example.reviewcard.viewmodel.NoteViewModelFactory
import com.example.reviewcard.viewmodel.WordViewModel
import com.example.reviewcard.viewmodel.WordViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Room DB
        val database = WordsNotesDB.getInstance(applicationContext)

        // Repositories
        val wordRepository = WordsRepository(wordDao = database.wordsDao)
        val noteRepository = NotesRepository(noteDao = database.notesDao)

        // ViewModel Factories
        val wordViewModelFactory = WordViewModelFactory(repository = wordRepository)
        val noteViewModelFactory = NoteViewModelFactory(repository = noteRepository)

        // ViewModels
        val wordViewModel = ViewModelProvider(this, wordViewModelFactory)[WordViewModel::class.java]
        val noteViewModel = ViewModelProvider(this, noteViewModelFactory)[NoteViewModel::class.java]



        setContent {
            ReviewCardTheme {
                val wordsList by wordViewModel
                    .allWords.observeAsState(initial = wordViewModel.allWords.value ?: emptyList())

                val notesList by noteViewModel
                    .allNotes.observeAsState(initial = noteViewModel.allNotes.value ?: emptyList())

                val wordsListForReview by
                wordViewModel.allWordsForReview.observeAsState(initial = wordViewModel.allWordsForReview.value ?: emptyList())

                val notesListForReview by
                noteViewModel.allNotesForReview.observeAsState(initial = noteViewModel.allNotesForReview.value ?: emptyList())

                val navController = rememberNavController()

                NavGraph(
                    navController = navController,
                    wordsList = wordsList,
                    notesList = notesList,
                    wordsListForReview = wordsListForReview,
                    notesListForReview = notesListForReview,
                    wordViewModel = wordViewModel,
                    noteViewModel = noteViewModel,
                    context = applicationContext
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TestPreview() {
    ReviewCardTheme {

    }
}