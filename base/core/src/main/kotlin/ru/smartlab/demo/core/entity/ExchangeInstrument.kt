package ru.smartlab.demo.core.entity

import ru.smartlab.demo.core.enum.ExInstrument

data class ExchangeInstrument(
    val id: Long = -1,

    val type: String = ExInstrument.Type.STOCK,
    val name: String = "Gazprom",
    val rating: Int = 1,
    val ticket: String = "GAZP",
    val group: String = ExInstrument.Direction.GAZ_AND_OIL,
    val index: List<String> = listOf(), // Индекс (IMOEX, MOEX10, IRTS, RTS2)
    val lastPrice: Float = 200f,
    val lastPriceChange: Float = -1.26f,
    val turnover: String = "14,4 млрд"
)