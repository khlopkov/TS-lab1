package core.actions

import org.openqa.selenium.WebDriver

class NavigateBack: Actionable {
    override val description: String
        get() = "происходит перенаправление на прошлую страницу"

    override fun `do`(driver: WebDriver) {
        driver.navigate().back()
    }
}
