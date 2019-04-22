package core.shoulds

import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebDriver

class PageShould(private val what: String, private val expectation: (SearchContext) -> Boolean) : Expectable {
    override val description: String
        get() = "Should ${this.what}"

    override fun should(driver: WebDriver): Boolean {
        return this.expectation(driver)
    }
}
