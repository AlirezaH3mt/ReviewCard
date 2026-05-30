package com.example.reviewcard.pages.wordpage


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.reviewcard.R
import com.example.reviewcard.model.Word
import com.example.reviewcard.pages.TopAppBarTemp
import com.example.reviewcard.pages.wordpage.components.InfoCard
import com.example.reviewcard.pages.wordpage.components.WordDisplayCard
import com.example.reviewcard.pages.wordpage.components.WordPageButtons
import com.example.reviewcard.viewmodel.WordViewModel

@Composable
fun WordsMainPage(
    navController: NavController,
    wordViewModel: WordViewModel,
    wordsListForReview: List<Word>
) {

    var itemIndex by remember {
        mutableIntStateOf(0)
    }

    var wordsListMut by remember {
        mutableStateOf(wordsListForReview)
    }

    var isNewCard by remember {
        mutableStateOf(false)
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBarTemp(barTitle = "Review Words", navController = navController) },
        containerColor = colorResource(R.color.dark_gray)
    )
    { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

            // Bounds check for safety before accessing the list
            if (wordsListMut.isNotEmpty() && itemIndex in wordsListMut.indices) {
                val currentWord = wordsListMut[itemIndex]


                InfoCard(word = currentWord)
                WordDisplayCard(word = currentWord, isNewCard = isNewCard)

                WordPageButtons(
                    onRightClick = {
                        isNewCard = true
                        val updatedWord = currentWord.copy(
                            repeatNum = currentWord.repeatNum + 1,
                            correctNum = currentWord.correctNum + 1
                        )
                        wordViewModel.update(updatedWord)
                        // Correctly updates itemIndex, triggering recomposition
                        if (itemIndex < wordsListForReview.size - 1) {
                            itemIndex += 1
                        }
                        else{
                            itemIndex = 0
                        }
                    },
                    onWrongClick = {
                        isNewCard = true
                        val updatedWord = currentWord.copy(
                            repeatNum = currentWord.repeatNum + 1,
                            // Note: correctNum does NOT change on wrong answer
                        )
                        wordViewModel.update(updatedWord)
                        if (itemIndex < wordsListForReview.size - 1){
                            itemIndex += 1
                        }
                        else{
                            itemIndex = 0
                        }
                    }
                )
            } else {
                // Display a message when the list is empty or review is complete
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(
                        text = "No words for review or list is empty.",
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
fun WordsMainPagePreview(){
    //WordsMainPage()
}