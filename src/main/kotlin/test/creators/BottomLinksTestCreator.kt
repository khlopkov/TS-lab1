package test.creators

import core.actions.Click
import core.elements.ElementBySelector
import core.elements.ElementByXpath
import core.shoulds.ElementShouldContainText
import core.shoulds.UrlShould
import core.test.TestCase
import presets.HomePagePreset

enum class BottomLink(val index: Int, val expectedUrl: String, val expectedHeader: String) {
    Department(1, "https://student.itmo.ru/pages/16/", "Департамент молодежной политики"),
    Forums(2, "https://student.itmo.ru/rosmol/", "Форумы и лагеря"),
    StudsUnionDevelopment (3, "https://student.itmo.ru/pages/8/", "Программа развития деятельности студенческих объединений"),
    Infrastructure(4, "https://student.itmo.ru/pages/10/", "Социальная инфраструктура")
}

class BottomLinksTestCreator(testId: String, link: BottomLink) : TestCaseCreator {
    override val testCase: TestCase =
        TestCase("Тестирование круглой ссылки внизу страницы ведущую на \"${link.expectedHeader}\"", testId, HomePagePreset())

    init {
        testCase.addAction(Click(ElementByXpath("/html/body/footer/div[1]/div[3]/div/a[${link.index}]")))
    }

    init {
        testCase.addExpectation(
            UrlShould("быть равной ${link.expectedUrl}") {
                it == link.expectedUrl
            }
        )

        testCase.addExpectation(ElementShouldContainText(
            ElementBySelector("h2.page-header"), link.expectedHeader
        ))
    }
}