package com.devaruluis.exchanges.data.network

import com.devaruluis.exchanges.model.Coin
import com.devaruluis.exchanges.model.Exchange
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CoinApiService @Inject constructor(private val api: CoinApiClient) {
    suspend fun getCoins(): List<Coin> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllCoins()
            response.body() ?: emptyList()
        }
    }
}