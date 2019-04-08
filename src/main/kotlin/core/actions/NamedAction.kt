package core.actions

import org.openqa.selenium.WebDriver

interface NamedActionable : Actionable {
    val name: String
}

class NamedAction(override val name: String, private val action: Actionable) : NamedActionable {
    override val description: String
        get() = this.action.description
    override fun `do`(driver: WebDriver) {
        return this.action.`do`(driver)
    }
}
