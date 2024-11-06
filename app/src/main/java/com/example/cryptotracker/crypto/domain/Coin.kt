package com.example.cryptotracker.crypto.domain


data class Coin(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int,
    val priceUsd: Double,
    val marketUsdPrice: Double,
    val changedPercent24Hr: Double,
)





