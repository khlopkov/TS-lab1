package core.shoulds

import core.elements.ElementQuery

public class ElementShouldExist(val query: ElementQuery) : ElementShould (
        "exist",
        query,
        { it != null }
    ) { }
