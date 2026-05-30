package com.example.reviewcard.pages.welcomepage.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reviewcard.R

@Composable
fun AppInfo(){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    )
    {
        Text(
            text = "Review",
            fontSize = 41.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = colorResource(R.color.white)
        )
        Row {
            Spacer(modifier = Modifier.width(100.dp))
            Text(
                text = "Cards",
                fontSize = 41.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                color = colorResource(R.color.white)
            )
        }
    }
}


@Preview(showBackground = false)
@Composable
fun AppInfoPreview(){
    AppInfo()
}