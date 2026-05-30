package com.example.reviewcard.pages


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.reviewcard.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarTemp(barTitle : String,
                  navController: NavController
)
{

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
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(R.color.dirty_green),
            titleContentColor = colorResource(R.color.dark_gray),
            navigationIconContentColor = colorResource(R.color.dark_gray)
        )

    )

}






@Preview(showBackground = true)
@Composable
fun TopAppBarTempPreview(){
    //TopAppBarTemp(barTitle = "Main")
}