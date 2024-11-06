package com.example.cryptotracker.crypto.presentation.coin_list.components



import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptotracker.crypto.domain.Coin
import com.example.cryptotracker.crypto.presentation.model.CoinUi
import com.example.cryptotracker.crypto.presentation.model.toCoinUi
import com.example.cryptotracker.ui.theme.backgroundDark
import com.example.cryptotracker.ui.theme.backgroundLight
import com.example.cryptotracker.ui.theme.greenBackground
import com.example.cryptotracker.ui.theme.primaryLight



@Composable
fun CoinListItem(
    coin: CoinUi,
    onClick: () -> Unit,
    modifier: Modifier
) {
    val containerColor = if(isSystemInDarkTheme()) backgroundDark else backgroundLight
    val contentColor = if(isSystemInDarkTheme()) Color.White else primaryLight

    Row(
        modifier = modifier
            .clickable { onClick() }
            .background(color = containerColor)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Icon(
            modifier = Modifier.size(80.dp),
            imageVector = ImageVector.vectorResource(id = coin.iconResId),
            contentDescription ="" ,
            tint = greenBackground)
        Column(
            modifier = Modifier.weight(1f).padding(start = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ){
            Text(text = coin.symbol,
                color = contentColor,
                style = MaterialTheme.typography.titleLarge,
                fontSize = 20.sp)
            Text(text = coin.name,
                color = contentColor,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp)
        }

        Column(
            modifier = Modifier.padding(end = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.End
        ){
            Text(text = "$ ${coin.priceUsd.formatted}",
                color = contentColor,
                style = MaterialTheme.typography.titleLarge,
                fontSize = 18.sp)
            ChangePrice(coin.changedPercent24Hr)
        }
    }

}



@PreviewLightDark
@Composable
fun PreviewCoin(){
    CoinListItem(modifier = Modifier,
        onClick = { /*TODO*/ },
        coin = previewCoin
    )
}

val previewCoin = Coin(
    id = "1",
    name = "Bitcoin",
    symbol = "BTC",
    rank = 1,
    priceUsd = 63329657.24,
    marketUsdPrice = 8237468273687235.0,
    changedPercent24Hr = 1.0,
).toCoinUi()