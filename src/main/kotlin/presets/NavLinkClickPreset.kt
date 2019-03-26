package presets

import core.actions.Click
import core.elements.ElementByXpath
import core.test.TestPreset

public enum class NavBarLink(val index: Int) {
    Staff(0),
    Achivements(1),
    News(2),
    Projects(3),
    Files(4),
    Media(5),
    Info(6),
    Partners(7)
}

public class NavLinkClickPreset(private val link: NavBarLink): TestPreset(HomePagePreset()) {
    init {
        this.addAction(Click(ElementByXpath("//nav[contains(@class, 'navbar')]//a[${this.link.index}]")))
    }
}
