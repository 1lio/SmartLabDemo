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
            turnover = "205 млн"
        ),

        ExchangeInstrument(
            name = "LSR",
            ticket = "LSRG",
            group = ExInstrument.Direction.CONSTRUCTION,
            lastPrice = 950.5f,
            lastPriceChange = 10.03f,
            turnover = "57 млн"
        ),

        ExchangeInstrument(
            name = "Gazprom",
            ticket = "GAZP",
            group = ExInstrument.Direction.GAZ_AND_OIL,
            lastPrice = 224.03f,
            lastPriceChange = -1.26f,
            turnover = "14.4 млрд"
        ),

        ExchangeInstrument(
            name = "Lukhoil",
            ticket = "LKOH",
            group = ExInstrument.Direction.GAZ_AND_OIL,
            lastPrice = 5871.5f,
            lastPriceChange = -0.03f,
            turnover = "7.1 млрд"
        ),

        ExchangeInstrument(
            name = "Rosneft",
            ticket = "ROSN",
            group = ExInstrument.Direction.GAZ_AND_OIL,
            lastPrice = 509.5f,
            lastPriceChange = -0.66f,
            turnover = "6.3 млрд"
        ),
        ExchangeInstrument(
            name = "TanNeft",
            ticket = "TATN",
            group = ExInstrument.Direction.GAZ_AND_OIL,
            lastPrice = 529.5f,
            lastPriceChange = -0.66f,
            turnover = "1.9 млрд"
        ),
        ExchangeInstrument(
            name = "Novatek",
            ticket = "NVKT",
            group = ExInstrument.Direction.GAZ_AND_OIL,
            lastPrice = 1374.5f,
            lastPriceChange = -1.18f,
            turnover = "1.36 млрд"
        ),

        ExchangeInstrument(
            name = "GazPromNeft",
            ticket = "Sibn",
            group = ExInstrument.Direction.GAZ_AND_OIL,
            lastPrice = 35.965f,
            lastPriceChange = -0.74f,
            turnover = "14.4 млрд"
        ),
        ExchangeInstrument(
            name = "Yatek",
            ticket = "YATG",
            group = ExInstrument.Direction.GAZ_AND_OIL,
            lastPrice = 35.965f,
            lastPriceChange = -0.74f,
            turnover = "14.4 млрд"
        ),

        //fin

        ExchangeInstrument(
            name = "SBER",
            ticket = "SBER",
            group = ExInstrument.Direction.FINANCE,
            lastPrice = 227.965f,
            lastPriceChange = -0.88f,
            turnover = "15.4 млрд"
        ),

        ExchangeInstrument(
            name = "Moscow Exchange",
            ticket = "MOEX",
            group = ExInstrument.Direction.FINANCE,
            lastPrice = 165.555f,
            lastPriceChange = 3.4f,
            turnover = "3.4 млрд"
        ),

        //metal

        ExchangeInstrument(
            name = "Nornikel",
            ticket = "GMKN",
            group = ExInstrument.Direction.METALLURGY,
            lastPrice = 25750f,
            lastPriceChange = -0.48f,
            turnover = "4.9 млрд"
        ),
        ExchangeInstrument(
            name = "Alrosa",
            ticket = "ALRS",
            group = ExInstrument.Direction.METALLURGY,
            lastPrice = 103.46f,
            lastPriceChange = -0.39f,
            turnover = "4.9 млрд"
        ),
        //it
        ExchangeInstrument(
            name = "Yandex",
            ticket = "YNDX",
            group = ExInstrument.Direction.IT,
            lastPrice = 4999.46f,
            lastPriceChange = -0.97f,
            turnover = "2.99 млрд"
        ),
        ExchangeInstrument(
            name = "OZON-DR",
            ticket = "OZON",
            group = ExInstrument.Direction.IT,
            lastPrice = 3971.5f,
            lastPriceChange = -4.7f,
            turnover = "1.99 млрд"
        ),

        //CONSUMER_SECTOR
        ExchangeInstrument(
            name = "Magnit",
            ticket = "MGNT",
            group = ExInstrument.Direction.CONSUMER_SECTOR,
            lastPrice = 5177.46f,
            lastPriceChange = -0.8f,
            turnover = "2.26 млрд"
        ),

        ExchangeInstrument(
            name = "X5 Grope",
            ticket = "FIVE",
            group = ExInstrument.Direction.CONSUMER_SECTOR,
            lastPrice = 2750f,
            lastPriceChange = 1.16f,
            turnover = "730 млн"
        ),
        //ENERGY
        ExchangeInstrument(
            name = "InterRao",
            ticket = "IRAO",
            group = ExInstrument.Direction.ENERGY,
            lastPrice = 5378.46f,
            lastPriceChange = -0.54f,
            turnover = "771 млн"
        ),

        ExchangeInstrument(
            name = "Yaroslawsk SK",
            ticket = "YRSBP",
            group = ExInstrument.Direction.ENERGY,
            lastPrice = 2750f,
            lastPriceChange = 4.4f,
            turnover = "13.3 млн"
        ),

        //Transport
        ExchangeInstrument(
            name = "Aeroflot",
            ticket = "AFLT",
            group = ExInstrument.Direction.TRANSPORT,
            lastPrice = 73.76f,
            lastPriceChange = 1.3f,
            turnover = "1.75 млрд"
        ),

        ExchangeInstrument(
            name = "Sowkom Flot",
            ticket = "FLOT",
            group = ExInstrument.Direction.ENERGY,
            lastPrice = 91.42f,
            lastPriceChange = -0.64f,
            turnover = "79.3 млн"
        ),
        //chemistry
        ExchangeInstrument(
            name = "FosAgro",
            ticket = "PHOR",
            group = ExInstrument.Direction.CHEMISTRY,
            lastPrice = 3415f,
            lastPriceChange = -1.3f,
            turnover = "545 млн"
        ),

        ExchangeInstrument(
            name = "AKRON",
            ticket = "AKRN",
            group = ExInstrument.Direction.CHEMISTRY,
            lastPrice = 5982f,
            lastPriceChange = 0f,
            turnover = "22.3 млн"
        ),

        // Other

        ExchangeInstrument(
            name = "Qiwi",
            ticket = "QIWI",
            group = ExInstrument.Direction.OTHER,
            lastPrice = 773f,
            lastPriceChange = 0f,
            turnover = "148 млн"
        ),

        ExchangeInstrument(
            name = "Telegraf",
            ticket = "CNTL",
            group = ExInstrument.Direction.OTHER,
            lastPrice = 18f,
            lastPriceChange = -6f,
            turnover = "51 млн"
        ),
        // APK

        ExchangeInstrument(
            name = "Agro",
            ticket = "ARGO",
            group = ExInstrument.Direction.AGRO,
            lastPrice = 892.1f,
            lastPriceChange = 0.09f,
            turnover = "135 млн"
        ),

        ExchangeInstrument(
            name = "Russgrain",
            ticket = "RUGR",
            group = ExInstrument.Direction.AGRO,
            lastPrice = 9.044f,
            lastPriceChange = -0.33f,
            turnover = "11,5 млн"
        ),

        //machine
        ExchangeInstrument(
            name = "obk",
            ticket = "UWGN",
            group = ExInstrument.Direction.MECHANICAL_ENGINEERING,
            lastPrice = 144.3f,
            lastPriceChange = 0f,
            turnover = "9 млн"
        ),

        ExchangeInstrument(
            name = "GAZ",
            ticket = "GAZA",
            group = ExInstrument.Direction.MECHANICAL_ENGINEERING,
            lastPrice = 481.5f,
            lastPriceChange = 2.01f,
            turnover = "7,8 млн"
        ),


        )

    override fun getStockList(filter: (instrument: ExchangeInstrument) -> Boolean): List<ExchangeInstrument> {
        return getListStocks().filter { filter(it) }
    }

}