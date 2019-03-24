package core.shoulds

import core.elements.ElementFinder
import core.elements.ElementQuery
import core.exceptions.ElementNotFoundException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

public open class ElementShould(
        protected val what: String,
        private val query: ElementQuery,
        private val elementShould: (WebElement) -> Boolean
) : Shouldable {
    override val description: String
        get() = "Element with ${this.query.identifierType} \"${this.query.identifier}\" should ${this.what}"

    protected fun findElement(driver: WebDriver): WebElement {
        try {
            return ElementFinder(this.query).findElement(driver)
        }
        catch (e: NoSuchElementException) {
            throw ElementNotFoundException(this.query)
        }
    }

    override fun should(driver: WebDriver): Boolean {
        return this.elementShould(this.findElement(driver))
    }
}
