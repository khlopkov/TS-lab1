package core.shoulds

import core.elements.ElementQuery

class ElementShouldExist(query: ElementQuery) : ElementShould (
        "существовать",
        query,
        { true }
    )
