package com.example.cryptotracker.crypto.data.networking

import kotlinx.serialization.Serializable

@Serializable
data class CoinsResponseDto(
    val data: List<CoinDto>,
)
