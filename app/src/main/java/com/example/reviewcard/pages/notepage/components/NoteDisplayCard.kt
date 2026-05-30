package com.example.reviewcard.pages.notepage.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reviewcard.R
import com.example.reviewcard.model.Note

@Composable
fun NoteDisplayCard(note: Note, isNewCard : Boolean){

    var isFlipped by remember {
        mutableStateOf(false)
    }

    if (isNewCard){
        isFlipped = false
    }

    val scrollState = rememberScrollState()

    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.super_light_blue),
        ),
        modifier = Modifier.padding(32.dp).fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .width(300.dp)
                .height(350.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (!isFlipped){
                Text(
                    text = note.noteTitle,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.black)
                )
            }
            else{
                Text(
                    text = "Description:",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.black)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = note.description,
                    fontSize = 18.sp,
                    color = colorResource(R.color.dark_gray)
                )

            }


        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = {
                    isFlipped = !isFlipped
                },
                modifier = Modifier.width(100.dp),
            ) {
                Row (
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Icon(
                        painter = painterResource(R.drawable.flip_icon),
                        contentDescription = "Flip Icon",
                        tint = colorResource(R.color.black)
                    )
                    Text(
                        text = "Flip",
                        fontSize = 18.sp,
                        color = colorResource(R.color.black)
                    )
                }

            }
        }



    }
}