package core.elements

import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebElement

class ElementFinder(private val query: ElementQuery) : Queriable {
    override fun findElement(searchCtx: SearchContext) : WebElement {
        return searchCtx.findElement(query.by)
    }

    override fun findElements(searchCtx: SearchContext) : List<WebElement>  {
        return searchCtx.findElements(query.by)
    }
}
