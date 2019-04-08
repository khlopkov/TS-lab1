package core.exceptions;

import core.elements.ElementQuery


public class ElementNotFoundException constructor(identifier: String, identifierType: String) : TestCaseException(
        "element with $identifierType \"$identifier\" was not found"
) {
    constructor(query: ElementQuery) : this(query.identifier, query.identifierType)
}
