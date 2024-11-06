package com.example.cryptotracker.crypto.presentation.coin_details.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptotracker.R

@Composable
fun InfoCard(
    title: String,
    icon: ImageVector,
    formatedText: String,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    modifier: Modifier = Modifier,
    // formated text style idk
) {

    val defaultTextStyle = LocalTextStyle.current.copy(
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        color = contentColor
    )

    Card(
        modifier = modifier
            .padding(8.dp)
            .shadow(
                elevation = 15.dp,
                shape = RectangleShape,
                ambientColor = MaterialTheme.colorScheme.primary,
                spotColor = MaterialTheme.colorScheme.primary
            ),
        shape = RectangleShape,
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.primary
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = contentColor
        ),
    ) {
        AnimatedContent(
            targetState = icon,
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            label = "Icon Animation"
        ) { icon ->
            Icon(
                imageVector = icon,
                modifier = Modifier
                    .size(75.dp)
                    .padding(top = 16.dp),
                contentDescription = "",
                tint = contentColor
            )
        }
        Spacer(modifier = Modifier.height(7.dp))
        AnimatedContent(
            targetState = formatedText,
            label = "formatedText"
        ) { formatedText ->
            Text(
                text = formatedText,
                style = defaultTextStyle,
                modifier = Modifier .padding(horizontal = 16.dp),
                fontWeight = FontWeight.Light,
                color = contentColor,
            )
        }
        Spacer(modifier = Modifier.height(7.dp))

        Text(
            text = title,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 8.dp).padding(horizontal = 14.dp),
            fontSize = 10.sp,
            fontWeight = FontWeight.Light,
            color = contentColor,
        )

    }
}

@PreviewLightDark
@Composable
private fun PreviewInfoCard() {
    InfoCard(
        title = "Price",
        icon = ImageVector.vectorResource(id = R.drawable.dollar),
        formatedText = "$ 124.432.324"
    )
}
