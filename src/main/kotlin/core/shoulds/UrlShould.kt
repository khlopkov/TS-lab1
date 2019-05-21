package core.shoulds

import org.openqa.selenium.WebDriver

class UrlShould(private val urlShouldWhat: String, private val urlShould: (String) -> Boolean) : Expectable {
    override val description: String
        get() = "URL должен ${this.urlShouldWhat}"

    override fun should(driver: WebDriver): Boolean {
        return this.urlShould(driver.currentUrl)
    }
}