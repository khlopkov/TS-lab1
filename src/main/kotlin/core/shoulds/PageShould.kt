package core.shoulds

import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebDriver

class PageShould(private val pageShouldWhat: String, private val expectation: (SearchContext) -> Boolean) : Expectable {
    override val description: String
        get() = "страница должна ${this.pageShouldWhat}"

    override fun should(driver: WebDriver): Boolean {
        return this.expectation(driver)
    }
}
