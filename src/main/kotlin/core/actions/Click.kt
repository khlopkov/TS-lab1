package core.actions

import core.elements.ElementFinder
import core.elements.ElementQuery
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class Click constructor(private val query: ElementQuery) : Actionable {
  private val elementFinder: ElementFinder = ElementFinder(this.query)

  override val description: String
    get() = "Нажатие на элемент с ${this.query.identifierType} \"${this.query.identifier}\""

  override fun `do`(driver: WebDriver) {
    val element: WebElement = this.elementFinder.findElement(driver)
    element.click()
  }
}