package core.elements

import org.openqa.selenium.By

abstract class ElementQuery constructor(val identifier: String, val by: By) {
    abstract val identifierType: String;
}

public class ElementById constructor(val id: String) : ElementQuery(id, By.id(id)) {
    override val identifierType: String
        get() = "id"
}

public class ElementByClass constructor(val className: String) : ElementQuery(className, By.className(className)) {
    override val identifierType: String
        get() = "className"
}

public class ElementByXpath constructor(val xpath: String) : ElementQuery(xpath, By.xpath(xpath)) {
    override val identifierType: String
        get() = "className"
}

