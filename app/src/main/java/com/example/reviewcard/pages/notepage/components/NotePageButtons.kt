package com.example.reviewcard.pages.notepage.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reviewcard.R
import com.example.reviewcard.pages.wordpage.components.RightBtn
import com.example.reviewcard.pages.wordpage.components.WrongBtn

@Composable
fun NotePageButtons(
    onRightClick : () -> Unit,
    onWrongClick : () -> Unit
)
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        WrongBtn(onWrongClick)
        RightBtn(onRightClick)
    }
}


@Composable
fun RightBtn(onClick : () -> Unit){
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(160.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(colorResource(R.color.green))
    )
    {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Icon(
                painter = painterResource(R.drawable.thumbs_up_icon),
                contentDescription = "I know Button.",
                tint = colorResource(R.color.white)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "I Know",
                fontSize = 13.sp,
                color = colorResource(R.color.white)
            )
        }

    }
}


@Composable
fun WrongBtn(onClick: () -> Unit){
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(160.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(colorResource(R.color.light_red))
    )
    {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Icon(
                painter = painterResource(R.drawable.thumbs_down_icon),
                contentDescription = "I know Button.",
                tint = colorResource(R.color.white)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "I Don't Know",
                fontSize = 13.sp,
                color = colorResource(R.color.white)
            )
        }

    }
}