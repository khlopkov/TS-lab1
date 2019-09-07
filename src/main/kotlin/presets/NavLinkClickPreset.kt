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

enum class FooterLink(val columnIndex: Int, val index: Int) {
    Staff(1, 1),
    Achievements(1, 2),
    News(1, 3),
    Projects(1, 4),
    Files(2, 1),
    Media(2, 2),
    Info(2, 3),
    Partners(2, 4)
}

class NavLinkClickPreset(private val link: NavBarLink): TestPreset(HomePagePreset()) {
    init {
        this.addAction(Click(ElementByXpath("/html/body/header/div/div/div[2]/nav/ul/li[${this.link.index}]/a")))
    }
}

class FooterLinkClickPreset(private val link: FooterLink): TestPreset(HomePagePreset()) {
    init {
        this.addAction(Click(ElementByXpath("/html/body/footer/div[2]/div/div[2]/div/div[${this.link.columnIndex}]/ul/li[${this.link.index}]/a")))
    }
}
