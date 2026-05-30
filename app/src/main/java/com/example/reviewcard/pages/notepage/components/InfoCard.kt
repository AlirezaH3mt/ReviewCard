package com.example.reviewcard.pages.notepage.components

import android.annotation.SuppressLint
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
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reviewcard.R
import com.example.reviewcard.model.Note
import java.text.DecimalFormat


@Composable
fun InfoCard(note: Note){
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
                    text = "${note.repeatNum}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(R.color.light_red)
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                val correctPercentage = (note.correctNum.toFloat() / note.repeatNum.toFloat()) * 100
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
//                    text = "#Box:",
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.SemiBold,
//                    color = colorResource(R.color.black)
//                )
//                Spacer(modifier = Modifier.width(3.dp))
//                Text(
//                    text = "${note.currentPos}",
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