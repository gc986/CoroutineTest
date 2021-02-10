package ru.gc986

import ru.gc986.repository.TmpCache
import ru.gc986.repository.provider.RequestBuilder
import ru.gc986.repository.webserver.SparkMain
import kotlinx.coroutines.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

val log: Logger = LoggerFactory.getLogger("Contributors")

fun main(args: Array<String>) {

    val cache = TmpCache()

    val portNumber = if (args.isNotEmpty())
        args[0].toInt()
    else
        9869

    SparkMain(portNumber, cache)

    val requestBuilder = RequestBuilder().build()

    requestBuilder.service.getBrandsCall().execute().body()?.data.let {
        if (cache.brands == null) cache.brands = mutableListOf()
        it?.res?.let { brands ->
            cache.brands?.addAll(brands)
        }


        println("brands size : ${it?.res?.size}")

        println("brands totalCount : ${it?.totalCount}")
        println("brands page : ${it?.page}")
        println("brands totalPages : ${it?.totalPages}")

        if (it?.totalPages != null && it.totalPages > 1) {
            (2..it.totalPages).forEach { pageNumber ->
                makeCoroutineRequest(pageNumber, requestBuilder, cache)
            }
        }
    }

}

fun makeCoroutineRequest(pageNumber: Int, requestBuilder: RequestBuilder, cache: TmpCache) {
    CoroutineScope(Dispatchers.Default).launch {
        val pages = requestBuilder.service.getBrands(pageNumber)

        log.info("Page number : $pageNumber")
        println()
        pages.body()?.data?.res?.let { brands ->
            if (cache.brands == null) {
                cache.brands = mutableListOf()
            }

            cache.brands?.addAll(brands)
        }

    }
}