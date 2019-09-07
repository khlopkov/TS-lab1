package test.creators

import core.elements.ElementByXpath
import core.shoulds.ElementShouldContainText
import core.test.TestCase
import presets.SearchPreset

private enum class SearchTabs(val index: Int, val text: String) {
    Persons(1, "Персоналии"),
    Organizations(2, "Организации"),
    News(3, "Новости"),
    Media(4, "Медиа")
}

class SearchTestCaseCreator(testId: String) : TestCaseCreator {
    override val testCase: TestCase = TestCase("Поиск", testId, SearchPreset("Запрос"))

    init {
        testCase.addExpectation(ElementShouldContainText(
            ElementByXpath("//h2[contains(@class, 'page-header')]"), "«Запрос»", true))
    }

    init {
        testCase.addExpectation(ElementShouldContainText(
            ElementByXpath("/html/body/div[1]/div/div/div/ul/li[${SearchTabs.Persons.index}]/a"), SearchTabs.Persons.text
        ))
        testCase.addExpectation(ElementShouldContainText(
            ElementByXpath("/html/body/div[1]/div/div/div/ul/li[${SearchTabs.Organizations.index}]/a"), SearchTabs.Organizations.text
        ))
        testCase.addExpectation(ElementShouldContainText(
            ElementByXpath("/html/body/div[1]/div/div/div/ul/li[${SearchTabs.News.index}]/a"), SearchTabs.News.text
        ))
        testCase.addExpectation(ElementShouldContainText(
            ElementByXpath("/html/body/div[1]/div/div/div/ul/li[${SearchTabs.Media.index}]/a"), SearchTabs.Media.text
        ))
    }
}