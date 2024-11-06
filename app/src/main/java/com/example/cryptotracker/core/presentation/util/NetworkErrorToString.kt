package com.example.cryptotracker.core.presentation.util

import android.content.Context
import com.example.cryptotracker.R
import com.example.cryptotracker.core.domain.util.NetworkError
import com.example.cryptotracker.core.domain.util.NetworkError.*

fun NetworkError.toString(context: Context):String{
    return when(this){
        RequestTimedOut -> context.getString(R.string.request_timed_out)
        UNAUTHORIZED -> context.getString(R.string.unauthorized)
        UNKNOWN_NETWORK_ERROR -> context.getString(R.string.unknown_network_error)
        SERIALIZATION_ERROR -> context.getString(R.string.serialization_error)
        TOO_MANY_REQUESTS -> context.getString(R.string.too_many_requests)
        SERVER_ERROR -> context.getString(R.string.server_error)
        NO_INTERNET_CONNECTION -> context.getString(R.string.no_internet_connection)
    }
}