package core.shoulds

import core.elements.ElementQuery

class ElementShouldBeVisible(query: ElementQuery) : ElementShould (
        "be visible",
        query,
        { it.isDisplayed }
)
