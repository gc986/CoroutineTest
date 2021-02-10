package ru.gc986.repository.webserver.pages

import ru.gc986.model.Brand
import ru.gc986.repository.webserver.pages.base.BasePage
import ru.gc986.repository.webserver.pages.base.HTMLTextBuilder

class BrandsPage(private val brands: List<Brand>?) : BasePage {

    override fun build(): String {
        return if (brands != null) {
            HTMLTextBuilder()
                .headerH1("Brands")
                .putStrings(brands.filter { it.name != null }.map { it.name!! }).build()
        } else {
            HTMLTextBuilder().headerH1("Brands not founded").build()
        }
    }

}