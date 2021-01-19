package ru.smartlab.demo.marketmap.model

data class ExchangeInstrument(
    val id: Long = -1,
    val type: String = "stock",
    val name: String = "Gazprom",
    val rating: Int = 1,
    val ticket: String = "GAZP",
    val group: String = "Oil and Gaz",
    val lastPrice: Float = 200f,
    val lastPriceChange: Float = -1.26f,
    val turnover: String = "14,4 млрд"
)