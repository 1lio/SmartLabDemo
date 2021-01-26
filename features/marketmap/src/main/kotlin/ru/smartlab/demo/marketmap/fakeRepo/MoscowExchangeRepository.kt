package ru.smartlab.demo.marketmap.fakeRepo

import ru.smartlab.demo.core.entity.ExchangeInstrument
import ru.smartlab.demo.core.enum.ExInstrument
import ru.smartlab.demo.marketmap.repository.ExchangeRepository

class MoscowExchangeRepository : ExchangeRepository {

    private fun getListStocks() = listOf(

        ExchangeInstrument(
            name = "PIK",
            ticket = "PIKK",
            group = ExInstrument.Direction.CONSTRUCTION,
            lastPrice = 643.3f,
            lastPriceChange = -1.11f,
            turnover = 205_000_000
        ),

        ExchangeInstrument(
            name = "LSR",
            ticket = "LSRG",
            group = ExInstrument.Direction.CONSTRUCTION,
            lastPrice = 950.5f,
            lastPriceChange = 10.03f,
            turnover = 57_000_000
        ),

        ExchangeInstrument(
            name = "Gazprom",
            ticket = "GAZP",
            group = ExInstrument.Direction.GAZ_AND_OIL,
            lastPrice = 224.03f,
            lastPriceChange = -1.26f,
            turnover = 14_400_000_000
        ),

        ExchangeInstrument(
            name = "Lukhoil",
            ticket = "LKOH",
            group = ExInstrument.Direction.GAZ_AND_OIL,
            lastPrice = 5871.5f,
            lastPriceChange = -0.03f,
            turnover = 7_400_000_000
        ),

        ExchangeInstrument(
            name = "Rosneft",
            ticket = "ROSN",
            group = ExInstrument.Direction.GAZ_AND_OIL,
            lastPrice = 509.5f,
            lastPriceChange = -0.66f,
            turnover = 6_400_000_000
        ),
        ExchangeInstrument(
            name = "TanNeft",
            ticket = "TATN",
            group = ExInstrument.Direction.GAZ_AND_OIL,
            lastPrice = 529.5f,
            lastPriceChange = -0.66f,
            turnover = 2_000_000_000
        ),
        ExchangeInstrument(
            name = "Novatek",
            ticket = "NVKT",
            group = ExInstrument.Direction.GAZ_AND_OIL,
            lastPrice = 1374.5f,
            lastPriceChange = -1.18f,
            turnover = 1_360_000_000
        ),

        ExchangeInstrument(
            name = "GazPromNeft",
            ticket = "Sibn",
            group = ExInstrument.Direction.GAZ_AND_OIL,
            lastPrice = 35.965f,
            lastPriceChange = -0.74f,
            turnover = 14_360_000_000
        ),
        ExchangeInstrument(
            name = "Yatek",
            ticket = "YATG",
            group = ExInstrument.Direction.GAZ_AND_OIL,
            lastPrice = 35.965f,
            lastPriceChange = -0.74f,
            turnover = 14_400_000_000
        ),

        //fin

        ExchangeInstrument(
            name = "SBER",
            ticket = "SBER",
            group = ExInstrument.Direction.FINANCE,
            lastPrice = 227.965f,
            lastPriceChange = -0.88f,
            turnover = 15_360_000_000
        ),

        ExchangeInstrument(
            name = "Moscow Exchange",
            ticket = "MOEX",
            group = ExInstrument.Direction.FINANCE,
            lastPrice = 165.555f,
            lastPriceChange = 3.4f,
            turnover = 3_460_000_000
        ),

        //metal

        ExchangeInstrument(
            name = "Nornikel",
            ticket = "GMKN",
            group = ExInstrument.Direction.METALLURGY,
            lastPrice = 25750f,
            lastPriceChange = -0.48f,
            turnover = 5_000_000_000
        ),
        ExchangeInstrument(
            name = "Alrosa",
            ticket = "ALRS",
            group = ExInstrument.Direction.METALLURGY,
            lastPrice = 103.46f,
            lastPriceChange = -0.39f,
            turnover = 5_000_000_000
        ),
        //it
        ExchangeInstrument(
            name = "Yandex",
            ticket = "YNDX",
            group = ExInstrument.Direction.IT,
            lastPrice = 4999.46f,
            lastPriceChange = -0.97f,
            turnover = 3_000_000_000
        ),
        ExchangeInstrument(
            name = "OZON-DR",
            ticket = "OZON",
            group = ExInstrument.Direction.IT,
            lastPrice = 3971.5f,
            lastPriceChange = -4.7f,
            turnover = 2_000_000_000
        ),

        //CONSUMER_SECTOR
        ExchangeInstrument(
            name = "Magnit",
            ticket = "MGNT",
            group = ExInstrument.Direction.CONSUMER_SECTOR,
            lastPrice = 5177.46f,
            lastPriceChange = -0.8f,
            turnover = 2_500_000_000
        ),

        ExchangeInstrument(
            name = "X5 Grope",
            ticket = "FIVE",
            group = ExInstrument.Direction.CONSUMER_SECTOR,
            lastPrice = 2750f,
            lastPriceChange = 1.16f,
            turnover = 790_000_000
        ),
        //ENERGY
        ExchangeInstrument(
            name = "InterRao",
            ticket = "IRAO",
            group = ExInstrument.Direction.ENERGY,
            lastPrice = 5378.46f,
            lastPriceChange = -0.54f,
            turnover = 770_000_000
        ),

        ExchangeInstrument(
            name = "Yaroslawsk SK",
            ticket = "YRSBP",
            group = ExInstrument.Direction.ENERGY,
            lastPrice = 2750f,
            lastPriceChange = 4.4f,
            turnover = 13_000_000
        ),

        //Transport
        ExchangeInstrument(
            name = "Aeroflot",
            ticket = "AFLT",
            group = ExInstrument.Direction.TRANSPORT,
            lastPrice = 73.76f,
            lastPriceChange = 1.3f,
            turnover = 1_790_000_000
        ),

        ExchangeInstrument(
            name = "Sowkom Flot",
            ticket = "FLOT",
            group = ExInstrument.Direction.ENERGY,
            lastPrice = 91.42f,
            lastPriceChange = -0.64f,
            turnover = 790_000_000
        ),
        //chemistry
        ExchangeInstrument(
            name = "FosAgro",
            ticket = "PHOR",
            group = ExInstrument.Direction.CHEMISTRY,
            lastPrice = 3415f,
            lastPriceChange = -1.3f,
            turnover = 545_000_000
        ),

        ExchangeInstrument(
            name = "AKRON",
            ticket = "AKRN",
            group = ExInstrument.Direction.CHEMISTRY,
            lastPrice = 5982f,
            lastPriceChange = 0f,
            turnover = 22_000_000
        ),

        // Other

        ExchangeInstrument(
            name = "Qiwi",
            ticket = "QIWI",
            group = ExInstrument.Direction.OTHER,
            lastPrice = 773f,
            lastPriceChange = 0f,
            turnover = 148_000_000
        ),

        ExchangeInstrument(
            name = "Telegraf",
            ticket = "CNTL",
            group = ExInstrument.Direction.OTHER,
            lastPrice = 18f,
            lastPriceChange = -6f,
            turnover = 51_000_000
        ),
        // APK

        ExchangeInstrument(
            name = "Agro",
            ticket = "ARGO",
            group = ExInstrument.Direction.AGRO,
            lastPrice = 892.1f,
            lastPriceChange = 0.09f,
            turnover = 135_000_000
        ),

        ExchangeInstrument(
            name = "Russgrain",
            ticket = "RUGR",
            group = ExInstrument.Direction.AGRO,
            lastPrice = 9.044f,
            lastPriceChange = -0.33f,
            turnover = 11_000_000
        ),

        //machine
        ExchangeInstrument(
            name = "obk",
            ticket = "UWGN",
            group = ExInstrument.Direction.MECHANICAL_ENGINEERING,
            lastPrice = 144.3f,
            lastPriceChange = 0f,
            turnover = 9_000_000
        ),

        ExchangeInstrument(
            name = "GAZ",
            ticket = "GAZA",
            group = ExInstrument.Direction.MECHANICAL_ENGINEERING,
            lastPrice = 481.5f,
            lastPriceChange = 2.01f,
            turnover = 7_000_000
        ),


        )

    // TODO: Исправить данную функцию. При пустом варианте ничего не вернет.
    override fun getStockList(filter: (instrument: ExchangeInstrument) -> Boolean): List<ExchangeInstrument> {
        return getListStocks().filter { filter(it) }
    }

}