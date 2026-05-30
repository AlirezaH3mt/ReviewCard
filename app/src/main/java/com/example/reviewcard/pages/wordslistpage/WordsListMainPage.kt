package com.example.reviewcard.pages.wordslistpage

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.reviewcard.R
import com.example.reviewcard.model.Word
import com.example.reviewcard.pages.BottomAppBarTemp
import com.example.reviewcard.pages.TopAppBarTemp
import com.example.reviewcard.pages.wordslistpage.components.AddWordFAB
import com.example.reviewcard.pages.wordslistpage.components.DisplayWordsList
import com.example.reviewcard.pages.wordslistpage.components.WordsListTAB
import com.example.reviewcard.viewmodel.WordViewModel


@Composable
fun WordsListMainPage(
    wordsList : List<Word>,
    navController: NavController,
    wordViewModel: WordViewModel,
    context: Context
){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { WordsListTAB(barTitle = "Words List", navController = navController, wordViewModel = wordViewModel, context = context) },
        bottomBar = { BottomAppBarTemp(navController = navController) },
        //floatingActionButton = { AddWordFAB(wordViewModel = wordViewModel, context = context) },
        containerColor = colorResource(R.color.dark_gray)
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            DisplayWordsList(wordsList = wordsList, wordViewModel = wordViewModel, context = context)
        }

    }
}


@Preview(showBackground = true)
@Composable
fun WordsListMainPagePreview(){
    //WordsListMainPage()
}















