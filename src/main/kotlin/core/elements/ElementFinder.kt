package core.elements

import core.exceptions.ElementNotFoundException
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.SearchContext
import org.openqa.selenium.WebElement

class ElementFinder(private val query: ElementQuery) : Queriable {
    override fun findElement(searchCtx: SearchContext) : WebElement {
        try {
            return searchCtx.findElement(query.by)
        }
        catch (e: NoSuchElementException) {
            throw ElementNotFoundException(this.query)
        }
    }

    override fun findElements(searchCtx: SearchContext) : List<WebElement>  {
        return searchCtx.findElements(query.by)
    }
}
