package presets

import core.actions.GetUrl
import core.test.TestPreset

public class HomePagePreset : TestPreset() {
    init {
        this.addPreaction(GetUrl("https://student.ifmo.ru/"))
    }
}