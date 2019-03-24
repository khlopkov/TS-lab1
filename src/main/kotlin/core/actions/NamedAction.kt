package core.actions

import org.openqa.selenium.WebDriver

public interface NamedActionable : Actionable {
    public val name: String
}

public class NamedAction(override val name: String, private val action: Actionable) : NamedActionable {
    override val description: String
        get() = this.action.description
    override fun Do(driver: WebDriver) {
        return this.action.Do(driver)
    }
}
