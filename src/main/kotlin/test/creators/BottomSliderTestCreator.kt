package test.creators

import core.actions.Click
import core.actions.DriverAction
import core.elements.ElementBySelector
import core.elements.ElementByXpath
import core.shoulds.ElementShould
import core.test.TestCase
import org.openqa.selenium.By
import presets.HomePagePreset

enum class BottomSliderDirection (val expectedIndexAfterClick: Int, val arrowSelector: String) {
    Next (2, ".fotorama__arr--next"),
    Previous (3, ".fotorama__arr--prev")
}

class BottomSliderTestCreator(direction: BottomSliderDirection, testId: String) : TestCaseCreator {
    override val testCase: TestCase = TestCase("переключение слайдера внизу главной страницы", testId, HomePagePreset())

    private val expectedImageAfterClick: String = "https://student.itmo.ru/images/footer_slider/big/p${direction.expectedIndexAfterClick}.jpg"

    init {
        testCase.addAction(Click(ElementBySelector(direction.arrowSelector)))
        testCase.addAction(DriverAction("Подождать") {
            Thread.sleep(1000)
        })
    }

    init {
        testCase.addExpectation(
            ElementShould("Выбранный элемент должен содержать ссылку на картинку $expectedImageAfterClick",
                ElementBySelector(".fotorama__loaded--img.fotorama__active")
            ){
                val element = it.findElement(By.tagName("img"))
                val src = element.getAttribute("src")
                src == expectedImageAfterClick
            })
    }

    init {
        testCase.addExpectation(
            ElementShould("Точка фоторамы с индексом ${direction.expectedIndexAfterClick} должна быть выбрана",
                ElementByXpath("//div[contains(@class, 'fotorama__nav__frame--dot')][${direction.expectedIndexAfterClick}]")
            ){
                it.getAttribute("class").contains("fotorama__active")
            }
        )
    }
}