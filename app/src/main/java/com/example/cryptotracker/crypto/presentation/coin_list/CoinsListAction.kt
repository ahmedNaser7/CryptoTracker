package com.example.cryptotracker.crypto.presentation.coin_list

import com.example.cryptotracker.crypto.presentation.model.CoinUi

sealed interface CoinsListAction {
    data class OnCoinClick(val coinUi: CoinUi) : CoinsListAction
//    data object OnRefresh : CoinsListAction
}