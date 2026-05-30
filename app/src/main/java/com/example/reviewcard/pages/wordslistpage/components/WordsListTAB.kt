package com.example.reviewcard.pages.wordslistpage.components

import android.content.Context
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.reviewcard.R
import com.example.reviewcard.viewmodel.WordViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WordsListTAB(barTitle : String,
                 navController: NavController,
                 wordViewModel: WordViewModel,
                 context: Context
)
{

    var showAddWordDialog by remember {
        mutableStateOf(false)
    }

    AddWordDialog(
        wordViewModel = wordViewModel,
        showDialog = showAddWordDialog,
        onDismiss = {showAddWordDialog = false},
        context = context
    )

    TopAppBar(
        title = {
            Text(
                text = barTitle
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {navController.navigateUp()}
            ){
                Icon(
                    painter = painterResource(R.drawable.arrow_back),
                    contentDescription = "Arrow Back Icon",
                )
            }
        },
        actions = {
            IconButton(
                onClick = {showAddWordDialog = true}
            ) {
                Icon(
                    painter = painterResource(R.drawable.add),
                    contentDescription = "Add Word",
                    tint = colorResource(R.color.dark_gray)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(R.color.dirty_green),
            titleContentColor = colorResource(R.color.dark_gray),
            navigationIconContentColor = colorResource(R.color.dark_gray)
        )

    )

}
