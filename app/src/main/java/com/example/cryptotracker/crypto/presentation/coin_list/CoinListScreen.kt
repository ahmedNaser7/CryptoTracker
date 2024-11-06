package com.example.cryptotracker.crypto.presentation.coin_list


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.cryptotracker.crypto.presentation.coin_list.components.CoinListItem


@Composable
fun CoinListScreen(
    modifier: Modifier,
    onAction: (CoinsListAction) -> Unit,
    state: CoinListState,
) {
    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(state.coins) {
                CoinListItem(
                    coin = it,
                    onClick = {
                        onAction(CoinsListAction.OnCoinClick(it))
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                HorizontalDivider()
            }

        }
    }

}

