package ru.smartlab.demo.feed.datastore.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class ParseService {

    private val hashMap = mutableMapOf<String, String>()


    init {

        GlobalScope.launch(Dispatchers.IO) {

            val jsoupDocument = Jsoup.connect("https://smart-lab.ru/").get()
            val elements: Elements = jsoupDocument.select(".title")

            for (e in elements) {
                val element1 = e.select("a[href]")
                hashMap[e.text()] = element1.attr("abs:href")
            }
        }

    }


    private suspend fun parseText(params: Array<String>): String {
        var str = ""

        GlobalScope.launch {

            val document = Jsoup.connect(params[0]).get()
            val element: Element = document.select(".content").first()
            str = element.text()
        }
        return str
    }

    suspend fun getMap() = hashMap

}