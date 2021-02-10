package ru.gc986.repository.webserver.pages.base

class HTMLTextBuilder {

    private var textBody: String = ""

    fun text(text: String):HTMLTextBuilder{
        textBody += text
        return this
    }

    fun headerH1(text: String):HTMLTextBuilder{
        textBody+="<h1>$text</h1>"
        return this
    }

    fun br():HTMLTextBuilder{
        textBody+="<br>"
        return this
    }

    fun putStrings(lines: List<String>):HTMLTextBuilder{
        lines.forEach {
            text(it)
            br()
        }
        return this
    }

    fun build() = textBody

}