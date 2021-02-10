package ru.gc986

import ru.gc986.repository.TmpCache
import ru.gc986.repository.provider.RequestBuilder
import ru.gc986.repository.webserver.SparkMain

fun main(args: Array<String>) {

    val cache = TmpCache()

    val portNumber = if (args.isNotEmpty())
                    args[0].toInt()
                else
                    9869

    SparkMain(portNumber, cache)

    val requestBuilder = RequestBuilder().build()


    requestBuilder.service.getBrands().execute().body()?.let {
        cache.brands = it.data?.res
        println("brands size : ${it.data?.res?.size}")

        println("brands totalCount : ${it.data?.totalCount}")
        println("brands page : ${it.data?.page}")
        println("brands totalPages : ${it.data?.totalPages}")
    }

}

