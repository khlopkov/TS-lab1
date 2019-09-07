package presets

import core.actions.Click
import core.actions.DriverAction
import core.elements.ElementBySelector
import core.elements.ElementByXpath
import core.test.TestPreset
import org.openqa.selenium.By
import java.util.concurrent.TimeUnit

class SearchPreset(searchQuery: String) : TestPreset(HomePagePreset()) {
    init {
        addAction(Click(ElementByXpath("//button[contains(@class, 'b-nav-top__search-expand-btn')]")))
    }

    init {
        addAction(DriverAction("Ввести в строку поиска слово '$searchQuery'") {
            val el = it.findElement(By.cssSelector("input#search_query"))
            el.sendKeys(searchQuery)
        })
    }
    init {
        addAction(Click(ElementBySelector("button#async_search")))
        addAction(DriverAction("Подождать 1 секунду") {
            Thread.sleep(1000)
        })
    }
}
