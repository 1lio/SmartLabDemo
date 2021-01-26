package ru.smartlab.demo.marketmap.repository

import ru.smartlab.demo.core.entity.ExchangeInstrument

interface ExchangeRepository {

    fun getStockList(
        filter: (instrument: ExchangeInstrument) -> Boolean = { false }
    ): List<ExchangeInstrument>

}