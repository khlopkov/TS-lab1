package test.creators

import core.elements.ElementByXpath
import core.elements.ElementQuery
import core.shoulds.ElementShouldContainText
import core.shoulds.ElementShouldExist
import core.test.TestCase
import presets.FacultiesSidebarLinksPresset

enum class FacultiesSidebarLink(val linkQuery: ElementQuery, val header: String) {
    AboutUs(ElementByXpath("/html/body/div[1]/div/div[2]/ul/li[1]/a"), "О Нас"),
    Staff(ElementByXpath("/html/body/div[1]/div/div[2]/ul/li[2]/a"), "Состав"),
    Files(ElementByXpath("/html/body/div[1]/div/div[2]/ul/li[3]/a"), "Файлы")
}

class FacultiesSidebarLinksTestCaseCreator (dropdownLink: FacultiesDropdownLink, facultiesSidebarLink: FacultiesSidebarLink, testId: String) : TestCaseCreator {
    private val pageHeader = ElementByXpath("/html/body/div[1]/div/div[1]/h2")

    override val testCase: TestCase = TestCase(
            "Нажатие на ссылку ${facultiesSidebarLink.header}",
            testId,
            FacultiesSidebarLinksPresset(dropdownLink, facultiesSidebarLink)
    )
    init{
        this.testCase.addExpectation(ElementShouldExist(this.pageHeader))
        this.testCase.addExpectation(ElementShouldContainText(this.pageHeader, facultiesSidebarLink.header, true))
    }

}
