package kotlin.core.actions

import org.openqa.selenium.WebElement;

class Click constructor(val element: WebElement) : Actionable {
  override fun Do() {
    this.element.click();
  }
}