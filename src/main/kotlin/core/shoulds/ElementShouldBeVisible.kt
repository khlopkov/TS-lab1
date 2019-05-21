package core.shoulds

import core.elements.ElementQuery

class ElementShouldBeVisible(query: ElementQuery) : ElementShould (
        "быть visible",
        query,
        { it.isDisplayed }
)
