package com.example.cryptotracker.crypto.domain

import java.time.ZonedDateTime

data class CoinPrice(
    val price: Double,
    val dateTime: ZonedDateTime
)
