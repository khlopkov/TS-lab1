package core.elements

import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebElement

public interface Queriable {
    fun findElement(searchCtx: SearchContext) : WebElement
    fun findElements(searchCtx: SearchContext) : List<WebElement>
}

