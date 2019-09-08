package test.creators

import core.actions.Click
import core.elements.ElementByXpath
import core.shoulds.UrlShould
import core.test.TestCase
import presets.HomePagePreset

private const val expected_url = "https://student.itmo.ru/newslist/"
class AllNewsClickTestCaseCreator(testId: String) : TestCaseCreator {
    override val testCase: TestCase = TestCase("Нажатие кнопки \"Все новости\" на главной", testId, HomePagePreset())

    init {
        testCase.addAction(Click(ElementByXpath(
            "/html/body/div[1]/div/footer/a")))
    }

    init {
        testCase.addExpectation(UrlShould("равно $expected_url") {
            it == expected_url
        })
    }
}