package ru.smartlab.demo.network.impl

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import ru.smartlab.demo.core.entity.Topic
import ru.smartlab.demo.core.entity.User
import ru.smartlab.demo.core.utils.Constants.BASE_URL
import ru.smartlab.demo.network.api.SmartLabApi
import java.net.SocketTimeoutException

class SmartLabParserImpl : SmartLabApi {

    override fun getFeed(): Flow<List<Topic>> {
        return parse("/")
    }

    override fun getFeedAll(): Flow<List<Topic>> {
        return parse("/all")
    }

    override fun getFeedTop(top: String): Flow<List<Topic>> {
        return parse("/top/$top")
    }

    private fun parse(url: String = "/"): Flow<List<Topic>> {
        return flow {

            try {
                val jsoupDocument = Jsoup
                    .connect("$BASE_URL$url")
                    .referrer("http://www.google.com")
                    .timeout(3000)
                    .get()

                val elements: Elements = jsoupDocument.select(".main_content__item")

                val mutableList = mutableListOf<Topic>()

                for (e in elements) {

                    val tId = e.attr("tid")

                    val title = e.select(".main_content__item-title ").text()

                    val content = e.select(".main_content__item-text").text()
                    // val link = e.select(".title ").attr("abs:href")

                    val date = e.select(".main_content__item-time ").text()

                    val author = User(
                        name = e.select(".main_content__item-author").text(),
                        avatarUrl = e.select(".main_content__item-avatar").attr("src")
                    )

                    val likes = e
                        .select(".main_content__item-footer--likes")
                        .text()
                        .toIntNotNull()

                    // Пока кол-во просмотров невозможно спарсить, т.к. они подгружаются автоматически.
                    val reviews = e
                        .select(".main_content__item-footer--reviews")
                        .text()
                        .toIntNotNull()

                    val comments = e
                        .select(".main_content__item-footer--comments")
                        .text()
                        .toIntNotNull()

                    val feed = Topic(
                        tId = tId.toIntNotNull(),
                        title = title,
                        content = content,
                        author = author,
                        date = date,
                        countReviews = reviews,
                        countComments = comments,
                        countLikes = likes
                    )

                    mutableList.add(feed)
                }
                emit(mutableList)

            } catch (e: SocketTimeoutException) {
                emit(listOf<Topic>())
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }.flowOn(Dispatchers.IO)
    }

    private fun String.toIntNotNull(): Int = this.let { if (it.isEmpty()) 0 else it.toInt() }
}
