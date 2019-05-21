package core.actions

import org.openqa.selenium.WebDriver

class GetUrl constructor(private val url: String) : Actionable {
    override val description: String
        get() = "загружается страница с URL: ${this.url}"

    override fun `do`(driver: WebDriver) {
        driver.get(this.url)
    }
}
