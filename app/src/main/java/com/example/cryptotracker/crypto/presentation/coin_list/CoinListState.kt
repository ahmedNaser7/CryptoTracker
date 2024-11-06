package com.example.cryptotracker.crypto.presentation.coin_list


import com.example.cryptotracker.crypto.presentation.model.CoinUi

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUi> = emptyList(),
    val selectedCoin:CoinUi? = null,
)
