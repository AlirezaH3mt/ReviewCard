package com.example.reviewcard.pages.wordslistpage.components

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.reviewcard.model.Word
import com.example.reviewcard.viewmodel.WordViewModel

@Composable
fun DisplayWordsList(wordsList : List<Word>, wordViewModel: WordViewModel, context: Context){

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
    ){
        items(wordsList){
            eachItem -> WordsListItem(word = eachItem, wordViewModel = wordViewModel, context = context)
        }
    }

}