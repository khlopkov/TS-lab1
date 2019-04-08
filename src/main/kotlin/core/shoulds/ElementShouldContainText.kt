package core.shoulds

import core.elements.ElementQuery

class ElementShouldContainText(query: ElementQuery, text: String) : ElementShould(
        "должен содержать текст $text",
        query,
        { it.text.contains(text)}
)