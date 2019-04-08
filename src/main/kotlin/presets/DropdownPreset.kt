package presets

import core.actions.Click
import core.elements.ElementByXpath
import core.test.TestPreset

enum class DropdownListIdentifier(val id: String, val index: Int) {
    StudentsClubList("list_1", 1),
    FacultiesList("list_2", 2),
}

class DropdownPreset(listIdentifier: DropdownListIdentifier) : TestPreset(HomePagePreset()) {
    init {
        this.addAction(Click(ElementByXpath("//*[@id='${listIdentifier.id}']")))
    }
}