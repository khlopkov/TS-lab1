package core.shoulds

import core.elements.ElementFinder
import core.elements.ElementQuery
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

open class ElementShould(
        protected val what: String,
        private val query: ElementQuery,
        private val elementShould: (WebElement) -> Boolean
) : Shouldable {
    override val description: String
        get() = "Element with ${this.query.identifierType} \"${this.query.identifier}\" should ${this.what}"

    protected fun findElement(driver: WebDriver): WebElement {
        return ElementFinder(this.query).findElement(driver)
    }

    override fun should(driver: WebDriver): Boolean {
        return this.elementShould(this.findElement(driver))
    }
}
