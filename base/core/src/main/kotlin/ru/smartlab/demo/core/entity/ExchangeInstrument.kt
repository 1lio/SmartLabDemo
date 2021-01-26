package ru.smartlab.demo.core.entity

import ru.smartlab.demo.core.enum.ExchangeInstrument

data class ExchangeInstrument(
    val id: Long = -1,

    val type: String = ExchangeInstrument.Type.STOCK,
    val name: String = "Gazprom",
    val rating: Int = 1,
    val ticket: String = "GAZP",
    val group: String = ExchangeInstrument.Direction.GAZ_AND_OIL,
    val index: List<String> = listOf(), // Индекс (IMOEX, MOEX10, IRTS, RTS2)
    val lastPrice: Float = 200f,
    val lastPriceChange: Float = -1.26f,
    val turnover: String = "14,4 млрд"
)