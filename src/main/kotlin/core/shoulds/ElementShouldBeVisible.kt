package core.shoulds

import core.elements.ElementQuery

public class ElementShouldBeVisible(val query: ElementQuery) : ElementShould (
        "be visible",
        query,
        { it.isDisplayed }
) { }
