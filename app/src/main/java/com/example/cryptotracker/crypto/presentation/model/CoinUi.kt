package com.example.cryptotracker.crypto.presentation.model

import androidx.annotation.DrawableRes
import com.example.cryptotracker.core.presentation.util.getDrawableIdForCoin
import com.example.cryptotracker.crypto.domain.Coin
import com.example.cryptotracker.crypto.presentation.coin_details.DataPoint
import java.text.NumberFormat
import java.util.Locale

data class CoinUi(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val priceUsd: DisplayNumber,
    val marketUsdPrice: DisplayNumber,
    val changedPercent24Hr: DisplayNumber,
    val coinPriceHistory: List<DataPoint>,
    @DrawableRes val iconResId:Int
)

data class DisplayNumber(
    val value: Double,
    val formatted:String,
)


fun Coin.toCoinUi(): CoinUi {
    return CoinUi(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        priceUsd = priceUsd.toDisplayNumber(),
        marketUsdPrice = marketUsdPrice.toDisplayNumber(),
        changedPercent24Hr = changedPercent24Hr.toDisplayNumber(),
        coinPriceHistory = emptyList(),
        iconResId = getDrawableIdForCoin(symbol)
    )
}

fun Double.toDisplayNumber():DisplayNumber{
    val formater = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayNumber(
        value = this,
        formatted = formater.format(this)
    )
}
