package com.example.reviewcard.pages.welcomepage.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reviewcard.R

@Composable
fun WelcomeCards(
    onWordCardClick : () -> Unit,
    onNoteCardClick : () -> Unit
){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ){
        WordCard(
            onClick = onWordCardClick
        )
        NoteCard(
            onClick = onNoteCardClick
        )
    }
}


@Composable
fun WordCard(onClick : () -> Unit){
    Card (
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(16.dp)
            .size(150.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.super_light_blue)
        ),
        onClick = onClick
    )
    {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        )
        {
            Image(
                painter = painterResource(R.drawable.dictionary),
                contentDescription = "Note icon",
                modifier = Modifier.size(70.dp)
            )

            Text(
                text = "Words",
                fontSize = 26.sp,
                color = colorResource(R.color.black)
            )
        }
    }
}

@Composable
fun NoteCard(onClick : () -> Unit){
    Card (
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .padding(16.dp)
            .size(150.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.super_light_blue)
        ),
        onClick = onClick
    )
    {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        )
        {
            Image(
                painter = painterResource(R.drawable.note),
                contentDescription = "Note icon",
                modifier = Modifier.size(70.dp)
            )

            Text(
                text = "Notes",
                fontSize = 26.sp,
                color = colorResource(R.color.black)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WelcomeButtonsPreview(){
    WelcomeCards(
        onWordCardClick = {},
        onNoteCardClick = {}
    )
}