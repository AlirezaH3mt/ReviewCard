package com.example.reviewcard.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.reviewcard.model.Note
import com.example.reviewcard.model.Word
import com.example.reviewcard.pages.notepage.NotesMainPage
import com.example.reviewcard.pages.noteslistpage.NotesListMainPage
import com.example.reviewcard.pages.welcomepage.WelcomeMainPage
import com.example.reviewcard.pages.wordpage.WordsMainPage
import com.example.reviewcard.pages.wordslistpage.WordsListMainPage
import com.example.reviewcard.viewmodel.NoteViewModel
import com.example.reviewcard.viewmodel.WordViewModel


@Composable
fun NavGraph(
    navController: NavHostController,
    wordsList : List<Word>,
    notesList : List<Note>,
    wordsListForReview : List<Word>,
    notesListForReview : List<Note>,
    wordViewModel: WordViewModel,
    noteViewModel: NoteViewModel,
    context: Context
){

    NavHost(navController = navController, startDestination = NavRoute.Home.path){
        addHomeScreen(navController = navController, this)
        addWordsPageScreen(
            navController = navController,
            this,
            wordViewModel = wordViewModel,
            wordsListForReview = wordsListForReview
        )
        addNotesPageScreen(
            navController = navController,
            this,
            noteViewModel = noteViewModel,
            notesListForReview = notesListForReview
        )
        addWordsListPageScreen(
            navController = navController,
            this,
            wordsList = wordsList,
            wordViewModel = wordViewModel,
            context = context
        )
        addNotesListPageScreen(
            navController = navController,
            this,
            notesList = notesList,
            noteViewModel = noteViewModel,
            context = context
            )
    }

}


fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
){

    navGraphBuilder.composable(
        route = NavRoute.Home.path
    )
    {
        WelcomeMainPage(
            navigateToWordsPage = {
                navController.navigate(route = NavRoute.WordsPage.path)
            },
            navigateToNotesPage = {
                navController.navigate(route = NavRoute.NotesPage.path)
            },
            navController = navController
        )
    }

}


fun addWordsPageScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    wordViewModel: WordViewModel,
    wordsListForReview : List<Word>
){

    navGraphBuilder.composable(
        route = NavRoute.WordsPage.path
    )
    {
        WordsMainPage(
            navController = navController,
            wordViewModel = wordViewModel,
            wordsListForReview = wordsListForReview
        )
    }

}

fun addNotesPageScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    noteViewModel: NoteViewModel,
    notesListForReview : List<Note>
){

    navGraphBuilder.composable(
        route = NavRoute.NotesPage.path
    )
    {
        NotesMainPage(
            navController = navController,
            noteViewModel = noteViewModel,
            notesListForReview = notesListForReview
            )
    }

}


fun addWordsListPageScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    wordsList : List<Word>,
    wordViewModel: WordViewModel,
    context: Context
){

    navGraphBuilder.composable(
        route = NavRoute.WordsListPage.path
    )
    {
        WordsListMainPage(
            wordsList = wordsList,
            navController = navController,
            wordViewModel = wordViewModel,
            context = context
        )
    }

}

fun addNotesListPageScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    notesList : List<Note>,
    noteViewModel: NoteViewModel,
    context: Context
){

    navGraphBuilder.composable(
        route = NavRoute.NotesListPage.path
    )
    {
        NotesListMainPage(
            noteViewModel = noteViewModel,
            notesList = notesList,
            navController = navController,
            context = context
        )
    }

}

