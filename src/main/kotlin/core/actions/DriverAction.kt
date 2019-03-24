package core.actions

import org.openqa.selenium.WebDriver

public class DriverAction constructor(override val description: String, val driverAction: (WebDriver) -> (Unit)) : Actionable {
    override fun Do(driver: WebDriver) {
        return this.driverAction(driver)
    }
}
