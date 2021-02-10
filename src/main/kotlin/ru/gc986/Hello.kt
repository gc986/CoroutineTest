package ru.gc986

import spark.Spark

fun main(args: Array<String>) {

    val port = if (args.isNotEmpty())
                    args[0].toInt()
                else
                    9869

    println("try to open in web browser this http://localhost:$port/hello")

    Spark.port(port)

    Spark.get("hello"){ _, _ ->
        "Hi @username"
    }

}

