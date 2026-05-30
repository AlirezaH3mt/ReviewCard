package com.example.reviewcard.pages.welcomepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.reviewcard.R
import com.example.reviewcard.pages.BottomAppBarTemp
import com.example.reviewcard.pages.welcomepage.components.AppInfo
import com.example.reviewcard.pages.welcomepage.components.WelcomeCards


@Composable
fun WelcomeMainPage(
    navigateToWordsPage : () -> Unit,
    navigateToNotesPage : () -> Unit,
    navController: NavController
){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colorResource(R.color.dark_gray),
        bottomBar = { BottomAppBarTemp(navController = navController) }
    )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            AppInfo()

            Spacer(modifier = Modifier.height(80.dp))

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .background(
                        color = colorResource(R.color.white),
                        shape = RoundedCornerShape(
                            topStart = 50.dp,
                            topEnd = 50.dp
                        )
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {

                Spacer(modifier = Modifier.height(50.dp))
                Text(
                    text = "Choose The Category To Review",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(16.dp)
                )

                WelcomeCards(
                    onWordCardClick = navigateToWordsPage,
                    onNoteCardClick = navigateToNotesPage
                )
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun WelcomeMainPagePreview(){
    //WelcomeMainPage()
}









