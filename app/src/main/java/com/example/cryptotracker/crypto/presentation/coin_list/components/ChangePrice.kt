package com.example.cryptotracker.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptotracker.crypto.presentation.model.DisplayNumber
import com.example.cryptotracker.ui.theme.errorContainerDark
import com.example.cryptotracker.ui.theme.errorContainerLight
import com.example.cryptotracker.ui.theme.greenBackground


@Composable
fun ChangePrice(change: DisplayNumber) {

    val contentColor =  Color.White
    val backgroundColor = if(change.value > 0) greenBackground else {
        if (isSystemInDarkTheme())
            errorContainerDark
        else
            errorContainerLight
    }

     Row (
         modifier = Modifier
             .clip(RoundedCornerShape(100f))
             .background(backgroundColor)
             .padding(horizontal = 8.dp),
         verticalAlignment = Alignment.CenterVertically
     ){
         Icon(
             imageVector = if(change.value>0)Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
             contentDescription = ""
             , tint = contentColor,
             modifier = Modifier.size(20.dp)
         )
         Text(text = change.formatted, color = contentColor, fontSize = 14.sp)
     }
}

@PreviewLightDark
@Composable
fun PreviewChangePrice(){
    ChangePrice(change = DisplayNumber(123432534.0, "1.0"))
}