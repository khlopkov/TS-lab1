package core.shoulds

import core.actions.Actionable
import org.openqa.selenium.WebDriver

class ActionShould(private val what: String, private vararg val actions: Actionable, private val expectation: Shouldable) : AbstractShould() {
    override val description: String
        get() = "Should ${this.what}"

    private fun executeActions(driver: WebDriver) {
        for (action in actions) {
            action.`do`(driver)
        }
    }

    override fun should(driver: WebDriver): Boolean {
        executeActions(driver)
        return expectation.should(driver)
    }
}
