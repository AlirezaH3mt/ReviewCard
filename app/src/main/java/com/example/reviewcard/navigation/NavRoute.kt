package com.example.reviewcard.navigation

sealed class NavRoute (val path : String) {

    object Home : NavRoute("home")

    object WordsPage : NavRoute("wordsPage")

    object NotesPage : NavRoute("notesPage")

    object WordsListPage : NavRoute("wordsListPage")

    object NotesListPage : NavRoute("notesListPage")
}