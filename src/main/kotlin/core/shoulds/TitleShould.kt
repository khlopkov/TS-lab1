package core.shoulds

import org.openqa.selenium.WebDriver

class TitleShould(private val titleShouldWhat: String, private val titleShould: (String) -> Boolean) : Expectable {
    override val description: String
        get() = "Заголовок должен ${this.titleShouldWhat}"

    override fun should(driver: WebDriver): Boolean {
        return this.titleShould(driver.title)
    }
}