package core.actions

import org.openqa.selenium.WebDriver

class NavigateBack: Actionable {
    override val description: String
        get() = "go on previous page"

    override fun `do`(driver: WebDriver) {
        driver.navigate().back()
    }
}
