package test.creators

import core.actions.Click
import core.elements.ElementByXpath
import core.shoulds.ActionShould
import core.shoulds.ElementShould
import core.shoulds.UrlShould
import core.test.TestCase
import core.test.Testable
import presets.DropdownListIdentifier
import presets.DropdownPreset


enum class StudsDropdownLink(val index: Int, val title: String, val pageUrlIndex: Int) {
    AboutClubSystem(1, "О клубной системе", 77),
    ClubCreation(2, "Создание клуба", 78),
    ClubMentoring(3, "Менторство клубов", 79),
    FilesAndInstructions(4, "Файлы и инструкции", 81),
    ForClubLeader(5, "Руководителю клуба", 83),
    Clubs(6, "Клубы", 84)
}

class  StudsDropdownLinksClickTestCaseCreator(linkIdentifier: StudsDropdownLink, testId: String) : TestCaseCreator {
    private val headerQuery = ElementByXpath("/html/body/div[1]/div/div[1]/h2")
    private val linkQuery = ElementByXpath("/html/body/header/div[1]/div/div[2]/div/div[1]/div/div/div/div/ul/h4[${linkIdentifier.index}]/a")
    private val url = "https://student.ifmo.ru/pages/${linkIdentifier.pageUrlIndex}/"
    private var sidebarLinkQuery = ElementByXpath("/html/body/div[1]/div/div[2]/ul/li[${linkIdentifier.index}]/a")

    override val testCase: TestCase = TestCase(
            "Нажатие на ссылку выпадющего списка \"студеческие клубы\" ${linkIdentifier.title}",
            testId,
            DropdownPreset(DropdownListIdentifier.StudentsClubList)
    )

    init {
        testCase.addAction(Click(this.linkQuery))
    }

    init {
        val urlShould = UrlShould(
                "быть равным $url"
        ) { it == this.url }

        testCase.addExpectation(urlShould)

        val headerShould = ElementShould(
                "быть заголовком содержащим ${linkIdentifier.title}",
                this.headerQuery
        ) { it.text.contains(linkIdentifier.title, true) }

        testCase.addExpectation(headerShould)

        testCase.addExpectation(
            ActionShould(
                    "нажатие на ссылку ${linkIdentifier.title} на сайдбаре должно изменить URL на ${this.url}",
                    Click(this.sidebarLinkQuery),
                    expectation = urlShould
            )
        )
        testCase.addExpectation(headerShould)
    }
}