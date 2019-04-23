package presets

import core.actions.Click
import core.actions.GetUrl
import core.elements.ElementBySelector
import core.test.TestPreset

class OpenSliderPreset : TestPreset() {
    init {
        this.addPreaction(GetUrl("https://student.ifmo.ru/persons/28/"))
        this.addAction(Click(ElementBySelector("article.b-card-member:nth-child(4) > a:nth-child(1)")))
    }
}