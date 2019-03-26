package presets

import core.actions.Click
import core.elements.ElementByXpath
import core.test.TestPreset

enum class NavBarLink(val index: Int) {
    Staff(1),
    Achievements(2),
    News(3),
    Projects(4),
    Files(5),
    Media(6),
    Info(7),
    Partners(8)
}

class NavLinkClickPreset(private val link: NavBarLink): TestPreset(HomePagePreset()) {
    init {
        this.addAction(Click(ElementByXpath("/html/body/header/div/div/div[2]/nav/ul/li[${this.link.index}]/a")))
    }
}
