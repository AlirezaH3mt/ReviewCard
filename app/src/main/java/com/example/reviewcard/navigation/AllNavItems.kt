package com.example.reviewcard.navigation


import com.example.reviewcard.R


sealed class AllNavItems {

    object Home : BarItems(
        path = NavRoute.Home.path,
        title = "Home",
        iconPath = R.drawable.home_icon
    )

    object WordsListPage : BarItems(
        path = NavRoute.WordsListPage.path,
        title = "WordsListPage",
        iconPath = R.drawable.dictionary_icon
    )

    object NotesListPage : BarItems(
        path = NavRoute.NotesListPage.path,
        title = "NotesListPage",
        iconPath = R.drawable.note_icon
    )

}