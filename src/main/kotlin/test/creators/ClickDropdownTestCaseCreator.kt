package test.creators

import core.actions.Click
import core.elements.ElementByXpath
import core.shoulds.ActionShould
import core.shoulds.ElementShould
import core.shoulds.ElementShouldBeVisible
import core.test.TestCase
import core.test.Testable
import presets.DropdownListIdentifier
import presets.DropdownPreset

class ClickDropdownTestCaseCreator(listIdentifier: DropdownListIdentifier, testId: String) : TestCaseCreator {
    private val dropdownListLinkXPath: String = "//*[@id='${listIdentifier.id}']"
    override val testCase: TestCase = TestCase("Нажатие на выпадающий список ${listIdentifier.name}", testId, DropdownPreset(listIdentifier))
    private val dropdownMenuXPath: String = "/html/body/header/div/div/div[2]/div/div[${listIdentifier.index}]/div"

    init {
        this.testCase.addExpectation(ElementShouldBeVisible(ElementByXpath(
                this.dropdownMenuXPath
        )))
    }

    init {
        this.testCase.addExpectation(ActionShould(
                "нажатие снова скроет список",
                Click(ElementByXpath(this.dropdownListLinkXPath)),
                expectation =  ElementShouldBeVisible(
                    ElementByXpath(this.dropdownMenuXPath)
                )
            )
        )
    }
}