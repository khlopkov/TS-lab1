package presets

import core.actions.GetUrl
import core.test.TestPreset

class HomePagePreset : TestPreset() {
    init {
        this.addPreaction(GetUrl("https://student.ifmo.ru/"))
    }
}