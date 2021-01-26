package ru.smartlab.demo.feed.datastore.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import ru.smartlab.demo.core.entity.Topic
import ru.smartlab.demo.core.entity.User

class ParseService {

    private val hashMap = mutableMapOf<String, String>()


    /* init {

         GlobalScope.launch(Dispatchers.IO) {

             val jsoupDocument = Jsoup.connect("https://smart-lab.ru/").get()
             val elements: Elements = jsoupDocument.select(".title")

             for (e in elements) {
                 val element1 = e.select("a[href]")
                 hashMap[e.text()] = element1.attr("abs:href")
             }
         }

     }*/


    suspend fun subscribeBNews(): Flow<Topic> = flow {

        val jsoupDocument = Jsoup
            .connect("https://smart-lab.ru/")
            .referrer("http://www.google.com")
            .timeout(3000)
            .get()

        val elements: Elements = jsoupDocument.select(".topic")

        for (e in elements) {

            val title = e.select(".title ").text()

            val content = e.select(".content").text()
            // val link = e.select(".title ").attr("abs:href")

            val date = e.select(".date ").text()

            val author = User(
                name = e.select(".author").text()
            )

            val likes = e.select(".total").text().let {
                if (it.isNullOrEmpty()) 0 else it.toInt()
            }

            // Пока не получается корректно спарсить колличество просмотров
            val views = e.select(".views-total").attr("abs:title").let {

                if (it.isNullOrEmpty()) 0 else it.toInt()
            }

            val comments = e.select(".comments-total").select(".red").text().let {
                if (it.isNullOrEmpty()) 0 else it.toInt()
            }


            val feed = Topic(
                title = title,
                content = content,
                author = author,
                date = date,
                countViews = views,
                countComments = comments,
                countLikes = likes
            )

            emit(feed)
        }

    }.flowOn(Dispatchers.IO)


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