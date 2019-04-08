package core.shoulds

import org.openqa.selenium.WebDriver

class TitleShould(private val what: String, private val titleShould: (String) -> Boolean) : AbstractShould() {
    override val description: String
        get() = "Title should be ${this.what}"

    override fun should(driver: WebDriver): Boolean {
        return this.titleShould(driver.title)
    }
}