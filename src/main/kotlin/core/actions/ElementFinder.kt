package kotlin.core.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

abstract class ElementFinder constructor(val identifier: String, val driver: WebDriver) : Resultable<WebElement> {
  protected abstract fun By(identifier :String): By
  override fun result(): WebElement {
    return driver.findElement(By(this.identifier));
  }
}

class ElementFinderById(id: String, driver: WebDriver): ElementFinder(id, driver) {
  override fun By(identifier: String): By{
    return By.ById(identifier);
  }
}

class ElementFinderByTag(tagname: String, driver: WebDriver): ElementFinder(tagname, driver) {
  override fun By(identifier: String): By{
    return By.ByTagName(identifier)
  }
}

class ElementFinderByClass(className: String, driver: WebDriver): ElementFinder(className, driver) {
  override fun By(identifier: String): By{
    return By.ByClassName(identifier)
  }
}

class ElementFinderByXpath(xpath: String, driver: WebDriver): ElementFinder(xpath, driver) {
  override fun By(identifier: String): By{
    return By.ByClassName(identifier)
  }
}