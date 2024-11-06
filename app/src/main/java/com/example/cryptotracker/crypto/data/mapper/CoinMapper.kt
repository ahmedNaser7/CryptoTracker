package com.example.cryptotracker.crypto.data.mapper

import com.example.cryptotracker.crypto.data.networking.dto.CoinDto
import com.example.cryptotracker.crypto.data.networking.dto.CoinPriceDto
import com.example.cryptotracker.crypto.domain.Coin
import com.example.cryptotracker.crypto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        priceUsd = priceUsd,
        changedPercent24Hr = changePercent24Hr,
        marketUsdPrice = marketCapUsd
    )
}

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        price = priceUsd,
        dateTime = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.systemDefault())
    )
}