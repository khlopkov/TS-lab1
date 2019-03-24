package core.shoulds

import org.openqa.selenium.WebDriver

public class UrlShould(private val what: String, private val urlShould: (String) -> Boolean) : Shouldable {
    override val description: String
        get() = "Title should be ${this.what}"

    override fun should(driver: WebDriver): Boolean {
        return this.urlShould(driver.currentUrl)
    }
}