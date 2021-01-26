package ru.smartlab.demo.core.enum

object ExchangeInstrument {

    // Инструменты предоставляемые биржей
    object Type {
        const val STOCK = "stock"        // Акция
        const val BOND = "bond"          // Облигация
        const val FUTURE = "futures"     // Фьючерс
        const val OPTION = "option"      // Опцион
        const val FOREX = "forex"        // Форекс
        const val ALGO = "algo"          // Алго
        const val FOND = "fond"          // Фонд
        const val CRYPTO = "crypto"      // Криптовалюта
        const val CURRENCY = "currency"  // Валюта
    }

    // Направление (отрась) инструмента
    object Direction {
        const val GAZ_AND_OIL = "Gaz and Oil"
        const val FINANCE = "Finances"
        const val METALLURGY = "Metallurgy"
        const val IT = "IT"
        const val CONSUMER_SECTOR = "Consumer sector"
        const val ENERGY = "Energy"
        const val TRANSPORT = "Transport"
        const val CHEMISTRY = "Chemistry"
        const val AGRO = "agro"
        const val MECHANICAL_ENGINEERING = "Mechanical engineering"
        const val CONSTRUCTION = "Construction"
        const val HEALTHCARE = "Healthcare"
        const val OTHER = "Other"
    }
}