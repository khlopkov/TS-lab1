package core.shoulds

import org.openqa.selenium.WebDriver

interface Expectable {
    val description: String
    fun should(driver: WebDriver): Boolean
}