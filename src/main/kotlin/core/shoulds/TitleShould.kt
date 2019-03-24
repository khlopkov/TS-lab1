package core.shoulds

import org.openqa.selenium.WebDriver

public class TitleShould(private val what: String, private val titleShould: (String) -> Boolean) : Shouldable {
    override val description: String
        get() = "Title should be ${this.what}"

    override fun should(driver: WebDriver): Boolean {
        return this.titleShould(driver.title)
    }
}