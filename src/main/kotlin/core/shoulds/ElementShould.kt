package core.shoulds

import core.elements.ElementFinder
import core.elements.ElementQuery
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

open class ElementShould(
        private val shouldWhat: String,
        private val query: ElementQuery,
        private val elementShould: (WebElement) -> Boolean
) : Expectable {
    override val description: String
        get() = "элемент с ${this.query.identifierType} \"${this.query.identifier}\" должен ${this.shouldWhat}"

    private fun findElement(driver: WebDriver): WebElement {
        return ElementFinder(this.query).findElement(driver)
    }

    override fun should(driver: WebDriver): Boolean {
        return this.elementShould(this.findElement(driver))
    }
}
