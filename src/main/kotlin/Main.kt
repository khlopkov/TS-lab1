import core.actions.Click
import core.actions.DriverAction
import core.actions.GetUrl
import core.elements.ElementByXpath
import core.shoulds.ElementShould
import core.shoulds.ElementShouldExist
import core.shoulds.TitleShould
import core.test.TestCase
import presets.NavBarLink
import presets.NavLinkClickPreset

fun main(args: Array<String>) {
    testNabarStaffLink()
}

private val PageHeaderXPath: String = "//h2[contains(@class, 'page-header')]"
private val PageSubHeaderXPath: String = "//h4[contains(@class, 'page-sub-header')]"

fun testNabarStaffLink() {
    val testCase = TestCase("testStaffLink", NavLinkClickPreset(NavBarLink.Staff))

    testCase.addExpectation(TitleShould(
            "Состав Совет обучающихся Совет обучающихся университета ИТМО"
    ) { it.contains("Состав Совет обучающихся Совет обучающихся университета ИТМО", true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать слово Состав",
            ElementByXpath(PageHeaderXPath)
    ) { it.text == "Состав" })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageSubHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать Совет обучающихся",
            ElementByXpath(PageSubHeaderXPath)
    ) { it.text.contains("Совет обучающихся", true) })

    val message = testCase.runTest().message
    println(message)
}
