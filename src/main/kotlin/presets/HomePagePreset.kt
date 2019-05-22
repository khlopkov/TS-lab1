package presets

import core.actions.GetUrl
import core.test.TestPreset

class HomePagePreset : TestPreset() {
    init {
        this.addInitialCondition(GetUrl("https://student.ifmo.ru/"))
    }
}