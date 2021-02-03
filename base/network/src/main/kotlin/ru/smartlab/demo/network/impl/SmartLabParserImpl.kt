package ru.smartlab.demo.network.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.smartlab.demo.core.entity.Topic
import ru.smartlab.demo.core.entity.User
import ru.smartlab.demo.network.api.SmartLabApi
import ru.smartlab.demo.network.service.HtmlParser

class SmartLabParserImpl : SmartLabApi {

    override fun getFeed(): Flow<List<Topic>> {

        val topics = mutableListOf<Topic>()

        val l = HtmlParser
            .single(
                root = ".topic",
                keys = arrayOf(
                    ".title ", ".content", ".title", ".date ", ".author",
                    ".total", ".views-total", ".comments-total"
                )
            )

        val topic = Topic(
            title = l[0],
            content = l[1],
            author = User(l[2]),
            date = l[3],
            countViews = l[4].toIntNotNull(),
            countComments = l[5].toIntNotNull(),
            countLikes = l[6].toIntNotNull(),
        )

        topics.add(topic)

        return flow {

            var lastListSize = 0
            val newListSize = topics.size

            while (true) {

                if (newListSize > lastListSize) {
                    emit(topics)
                    lastListSize = newListSize
                }
            }

        }.flowOn(Dispatchers.IO)


/* override fun getFeed(): Flow<List<Topic>> {
 return flow {
     val jsoupDocument = Jsoup
         .connect("https://smart-lab.ru/")
         .referrer("http://www.google.com")
         .timeout(3000)
         .get()

     val elements: Elements = jsoupDocument.select(".topic")

     val mutableList = mutableListOf<Topic>()

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

         mutableList.add(feed)
     }
     emit(mutableList)
 }.flowOn(Dispatchers.IO)*/

    }

    override fun getFeedAll(): Flow<List<Topic>> {
        TODO("Not yet implemented")
    }

    override fun getFeedTop(top: Int): Flow<List<Topic>> {
        TODO("Not yet implemented")
    }


    private fun String.toIntNotNull(): Int = this.let { if (it.isEmpty()) 0 else it.toInt() }
}