package core.shoulds
import core.actions.Actionable
import org.openqa.selenium.WebDriver

interface Shouldable {
    fun then(action: Actionable): Shouldable
    val description: String
    fun should(driver: WebDriver): Boolean
}