package core.actions

import org.openqa.selenium.WebDriver

class DriverAction constructor(override val description: String, val driverAction: (WebDriver) -> (Unit)) : Actionable {
    override fun `do`(driver: WebDriver) {
        return this.driverAction(driver)
    }
}
