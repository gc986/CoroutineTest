package ru.gc986.repository.webserver

import ru.gc986.repository.TmpCache
import ru.gc986.repository.webserver.pages.BrandsPage
import spark.Spark

class SparkMain(private val portNumber: Int, private val cache: TmpCache) {

    init {
        Spark.port(portNumber)
        requestsRegistration()
    }

    private fun requestsRegistration() {
        println("try to open in web browser this http://localhost:$portNumber/hello")
        Spark.get("hello") { _, _ ->
            "Hi @username"
        }

        Spark.notFound { _, _ ->
            "Sorry, page not founded 404"
        }

        Spark.get("brands") { _, _ ->
            BrandsPage(cache.brands).build()
        }


    }

}