package ru.smartlab.demo.repo.interactor

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import ru.smartlab.demo.core.entity.Topic
import ru.smartlab.demo.core.entity.User
import ru.smartlab.demo.repo.api.SmartLabApi

class SmartLabParserImpl : SmartLabApi {

    override fun getFeed(): Flow<List<Topic>> {

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
        }

    }
}