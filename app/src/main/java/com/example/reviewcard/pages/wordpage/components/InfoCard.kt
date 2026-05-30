package com.example.reviewcard.pages.wordpage.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reviewcard.R
import com.example.reviewcard.WordTest
import com.example.reviewcard.model.Word
import com.example.reviewcard.pages.notepage.components.toTwoDecimalPlaces
import com.example.reviewcard.viewmodel.WordViewModel
import java.text.DecimalFormat


@Composable
fun InfoCard(word: Word){

    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.super_light_blue))
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "#Reviews:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(R.color.black)
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = "${word.repeatNum}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(R.color.light_red)
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                val correctPercentage = (word.correctNum.toFloat() / word.repeatNum.toFloat()) * 100
                Text(
                    text = "Correct:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(R.color.black)
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = "${correctPercentage.toTwoDecimalPlaces()}%",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(R.color.light_red)
                )
            }

//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Text(
//                    text = "Position:",
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    color = colorResource(R.color.black)
//                )
//                Spacer(modifier = Modifier.width(3.dp))
//                Text(
//                    text = "${word.currentPos}",
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    color = colorResource(R.color.light_red)
//                )
//            }

        }
    }
}

fun Float.toTwoDecimalPlaces(): String {
    // This is a simple pattern that forces 2 decimal places and handles rounding.
    return DecimalFormat("0.00").format(this)
}


@Preview(showBackground = true)
@Composable
fun InfoCardPreview(){
    InfoCard(
        word = WordTest().wordTest()
    )
}