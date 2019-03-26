import core.actions.Click
import core.actions.DriverAction
import core.actions.GetUrl
import core.elements.ElementByXpath
import core.shoulds.ElementShould
import core.shoulds.ElementShouldExist
import core.test.TestCase
import presets.NavBarLink
import presets.NavLinkClickPreset

fun main(args: Array<String>) {
    testNabarStaffLink()
}

private val PageHeaderXPath: String = "//h2[contains(@class, 'page-header')]"
private val PageSubHeaderXPath: String = "//h2[contains(@class, 'page-sub-header')]"

fun testNabarStaffLink() {
    val testCase = TestCase("test1", NavLinkClickPreset(NavBarLink.Staff))

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать слово Состав",
            ElementByXpath(PageHeaderXPath)
    ) { it.text == "Состав" })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать совет обучающихся",
            ElementByXpath(PageSubHeaderXPath)
    ) { it.text == "совет обучающихся" })

    val message = testCase.runTest().message
    println(message)
}
