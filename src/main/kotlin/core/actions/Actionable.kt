package core.actions

import org.openqa.selenium.WebDriver

interface Actionable {
  val description: String
  fun Do(driver: WebDriver)
}