package com.example.cryptotracker.core.domain.util

enum class NetworkError:Error {
    RequestTimedOut,
    UNAUTHORIZED,
    UNKNOWN_NETWORK_ERROR,
    SERIALIZATION_ERROR,
    TOO_MANY_REQUESTS,
    SERVER_ERROR,
    NO_INTERNET_CONNECTION,
}
