package com.example.cryptotracker.crypto.data.networking.dto

import com.example.cryptotracker.crypto.domain.CoinPrice
import kotlinx.serialization.Serializable
import java.time.Instant
import java.time.ZoneId


@Serializable
data class CoinPriceDto(
    val priceUsd: Double,
    val time: Long
)


fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        price = this.priceUsd,
        dateTime = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.of("UTC"))
    )
}
