package core.shoulds

import core.actions.Actionable
import org.openqa.selenium.WebDriver

class ActionShould(private val then : String, private vararg val actions: Actionable, private val expectation: Expectable) : Expectable {
    override val description: String
        get() = "${this.then}"

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
