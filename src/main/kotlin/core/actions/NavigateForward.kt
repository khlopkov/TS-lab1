package core.actions

import org.openqa.selenium.WebDriver

class NavigateForward: Actionable {
    override val description: String
        get() = "происходит перенаправление на следующую страницу"

    override fun `do`(driver: WebDriver) {
        driver.navigate().back()
    }
}
