package ru.smartlab.demo.network.service

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import ru.smartlab.demo.core.utils.Constants.BASE_URL

object HtmlParser {

    private var isSubscribe = false

    private val jsoupDocument =
        Jsoup
            .connect(BASE_URL)
            .get()


    // Return single result
    fun single(root: String, keys: Array<String>): List<String> {

        val elements: Elements = jsoupDocument.select(root)

        val array = arrayListOf<String>()

        for ((i, e) in elements.withIndex()) {
            array.add(e.select(keys[i]).text())
        }

        return array
    }

    fun subscribe(root: String, keys: Array<String>) = flow<List<String>> {

        isSubscribe = true

        GlobalScope.launch {

            while (isSubscribe) {

                val elements: Elements = jsoupDocument.select(root)

                val array = arrayListOf<String>()

                for ((i, e) in elements.withIndex()) {
                    array.add(e.select(keys[i]).text())
                    emit(array)
                }
            }
        }

    }.flowOn(Dispatchers.IO)

    fun unsubscribe() {
        isSubscribe = false
    }
}