package test_factories

import core.actions.Click
import core.elements.ElementByXpath
import core.shoulds.ActionShould
import core.shoulds.ElementShould
import core.shoulds.ElementShouldBeVisible
import core.test.TestCase
import core.test.Testable
import presets.DropdownListIdentifier
import presets.DropdownPreset

class ClickDropdownTestCaseFactory(listIdentifier: DropdownListIdentifier) {
    private val dropdownListLinkXPath: String = "//*[@id='${listIdentifier.id}']"
    val testCase: Testable
    private val dropdownMenuXPath: String = "/html/body/header/div/div/div[2]/div/div[${listIdentifier.index}]/div"

    init {
        this.testCase = TestCase("Нажатие на выпадающий список ${listIdentifier.name}", DropdownPreset(listIdentifier))
        this.testCase.addExpectation(ElementShouldBeVisible(ElementByXpath(
                this.dropdownMenuXPath
        )))
    }

    init {
        this.testCase.addExpectation(ActionShould(
                "Нажатие снова скроет список",
                Click(ElementByXpath(this.dropdownListLinkXPath)),
                expectation =  ElementShould(
                    "be visible",
                    ElementByXpath(this.dropdownMenuXPath)
                ) { !it.isDisplayed }
            )
        )
    }
}