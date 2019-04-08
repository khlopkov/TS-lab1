package core.shoulds

import core.elements.ElementQuery

class ElementShouldContainText(query: ElementQuery, text: String, ignoreCase: Boolean = false) : ElementShould(
        "должен содержать текст $text",
        query,
        { it.text.contains(text, ignoreCase)}
)