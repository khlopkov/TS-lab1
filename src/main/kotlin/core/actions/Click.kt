package core.actions

import core.elements.ElementFinder
import core.elements.ElementQuery
import core.exceptions.ElementNotFoundException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class Click constructor(private val query: ElementQuery) : Actionable {
  private val elementFinder: ElementFinder = ElementFinder(this.query)

  override val description: String
    get() = "click on element with ${this.query.identifierType} \"${this.query.identifier}\""

  override fun Do(driver: WebDriver) {
    try {
      var element: WebElement = this.elementFinder.findElement(driver)
      element.click()
    }
    catch (e: NoSuchElementException) {
      throw ElementNotFoundException(this.query)
    }
  }
}