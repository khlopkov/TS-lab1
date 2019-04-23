package core.elements

import org.openqa.selenium.By

abstract class ElementQuery constructor(val identifier: String, val by: By) {
    abstract val identifierType: String
}

class ElementById constructor(id: String) : ElementQuery(id, By.id(id)) {
    override val identifierType: String
        get() = "id"
}

class ElementByClass constructor(className: String) : ElementQuery(className, By.className(className)) {
    override val identifierType: String
        get() = "className"
}

class ElementByXpath constructor(xpath: String) : ElementQuery(xpath, By.xpath(xpath)) {
    override val identifierType: String
        get() = "xpath"
}

class ElementBySelector constructor(cssSelector: String) : ElementQuery(cssSelector,  By.cssSelector(cssSelector)) {
    override val identifierType: String
        get() = "cssSelector"
}

