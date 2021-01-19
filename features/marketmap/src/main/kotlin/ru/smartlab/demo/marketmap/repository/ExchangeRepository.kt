package ru.smartlab.demo.marketmap.repository

import kotlinx.coroutines.flow.Flow
import ru.smartlab.demo.marketmap.model.ExchangeInstrument

interface ExchangeRepository {

    fun getStockList(): Flow<List<ExchangeInstrument>>

}