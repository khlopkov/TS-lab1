package test.creators

import core.actions.Click
import core.elements.ElementByXpath
import core.shoulds.ElementShouldContainText
import core.shoulds.ElementShouldExist
import core.shoulds.UrlShould
import core.test.TestCase
import presets.DropdownListIdentifier
import presets.DropdownPreset


enum class FacultiesDropdownLink(val index: Int, val title: String, val url: String){
    IKT(1, "Факультет инфокоммуникационных технологий", "https://student.ifmo.ru/ikt/"),
    FTMI(2, "Факультет технологического менеджмента и инноваций", "https://student.ifmo.ru/ftmi/")
}

class FacultiesDropdownLinksTestCaseCreator(dropdownLink: FacultiesDropdownLink) : TestCaseCreator {
    private val pageHeader = ElementByXpath("/html/body/div[1]/div/div[1]/h2")

    override val testCase: TestCase = TestCase(
            "Нажатие на ссылку выпадющего списка \"студеческие клубы\" ${dropdownLink.title}",
            DropdownPreset(DropdownListIdentifier.FacultiesList)
    )

    init {
        val linkXpath = ElementByXpath("/html/body/header/div/div/div[2]/div/div[2]/div/div/div/div[${dropdownLink.index}]/h4/a")

        this.testCase.addAction(Click(linkXpath))
    }

    init {
        this.testCase.addExpectation(UrlShould("быть равным ${dropdownLink.url}") { it == dropdownLink.url })
    }

    init {
        val pageHeaderValue = "О нас"

        this.testCase.addExpectation(ElementShouldExist(pageHeader))
        this.testCase.addExpectation(ElementShouldContainText(pageHeader, pageHeaderValue))
    }

    init {
        val pageSubheader =  ElementByXpath("/html/body/div[1]/div/div[1]/h4")
        val pageSubheaderValue = dropdownLink.title

        this.testCase.addExpectation(ElementShouldExist(pageSubheader))
        this.testCase.addExpectation(ElementShouldContainText(pageSubheader, pageSubheaderValue, true))
    }

    init {
        val staffLink = ElementByXpath("/html/body/div[1]/div/div[2]/ul/li[2]/a")
        val staffLinkText = "Состав"

        this.testCase.addExpectation(ElementShouldExist(staffLink))
        // TODO: move to another test case
        this.testCase.addExpectation(ElementShouldContainText(staffLink, staffLinkText))
        //         .then(Click(staffLink)))

        // this.testCase.addExpectation(ElementShouldExist(this.pageHeader))
        // this.testCase.addExpectation(ElementShouldContainText(this.pageHeader, staffLinkText))
    }

    init {
        if (dropdownLink == FacultiesDropdownLink.FTMI) {
            val filesLink = ElementByXpath("/html/body/div[1]/div/div[2]/ul/li[3]/a")
            val filesLinkText = "Файлы"

            this.testCase.addExpectation(ElementShouldExist(filesLink))
            // TODO: move to another test case
            this.testCase.addExpectation(ElementShouldContainText(filesLink, filesLinkText))
            //         .then(Click(filesLink)))

            // this.testCase.addExpectation(ElementShouldExist(this.pageHeader))
            // this.testCase.addExpectation(ElementShouldContainText(this.pageHeader, filesLinkText))
        }
    }
}

