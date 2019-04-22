package core.shoulds

import core.actions.Actionable
import org.openqa.selenium.WebDriver

class ShouldWithAfteraction(private val expectation: Expectable, private val afteraction: Actionable) : Expectable {
    override val description: String
        get() = this.expectation.description

    override fun should(driver: WebDriver): Boolean {
        val result = this.expectation.should(driver)
        this.afteraction.`do`(driver)
        return result
    }
}