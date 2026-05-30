package com.example.reviewcard.pages.wordslistpage.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reviewcard.R
import com.example.reviewcard.WordTest
import com.example.reviewcard.model.Word
import com.example.reviewcard.viewmodel.WordViewModel

@Composable
fun WordsListItem(word: Word, wordViewModel: WordViewModel, context : Context){

    var showDialog by remember {
        mutableStateOf(false)
    }

    var showEditWordDialog by remember {
        mutableStateOf(false)
    }

    DeleteWordDialog(
        word = word,
        wordViewModel = wordViewModel,
        showDialog = showDialog,
        onDismiss = { showDialog = false}
    )

    EditWordDialog(
        word = word,
        wordViewModel = wordViewModel,
        showDialog = showEditWordDialog,
        onDismiss = { showEditWordDialog = false},
        context = context
    )

    Card (
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.super_light_blue)),
        modifier = Modifier
            .padding(12.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = word.wordTitle,
                    fontSize = 18.sp,
                    color = colorResource(R.color.black),
                    fontWeight = FontWeight.SemiBold
                )

//                Spacer(modifier = Modifier.width(12.dp))
//
//                Text(
//                    text = word.wordPhonetic,
//                    fontSize = 18.sp,
//                    color = colorResource(R.color.dark_gray),
//                    fontWeight = FontWeight.Normal,
//                    modifier = Modifier.width(150.dp)
//                )
            }

            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    onClick = {
                        showEditWordDialog = true
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.edit),
                        contentDescription = "Edit note"
                    )
                }

                IconButton(
                    onClick = {
                        showDialog = true
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.delete),
                        contentDescription = "Delete Icon"
                    )
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun WordsListItemPreview(){
//    WordsListItem(
//        word = WordTest().wordTest()
//    )
}