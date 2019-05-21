package test.creators

import core.elements.ElementBySelector
import core.shoulds.ElementShouldBeVisible
import core.shoulds.Expectable
import core.test.TestCase
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import presets.OpenSliderPreset

class ClickSliderTestCaseCreator : TestCaseCreator {
    override val testCase = TestCase("Нажатие на фото, открывающее слайдер", OpenSliderPreset())

    init {
        this.testCase.addExpectation(ElementShouldBeVisible(ElementBySelector("#blueimp-gallery-team")))
        this.testCase.addExpectation(SlidesBlocksWidthShouldBeCorrect())
        this.testCase.addExpectation(SlidesPositionShouldBeCorrect())
        this.testCase.addExpectation(ClickOnNextButtonShouldSwitchPhoto())
    }

    private class SlidesBlocksWidthShouldBeCorrect : Expectable{
        override fun should(driver: WebDriver): Boolean {
            val slidesCssSelector = "#blueimp-gallery-team div.slides"
            val slideCssSelector = "#blueimp-gallery-team div.slides div.slide"

            val slidesWrapper = driver.findElement(By.cssSelector(slidesCssSelector))
            val slides = driver.findElements(By.cssSelector(slideCssSelector))

            if (slides.count() == 0) {
                if (slidesWrapper.size.width == 0) {
                    return true
                }
                return false
            }

            if (slides.count() * slides[0].size.width == slidesWrapper.size.width) {
                return true
            }

            return false
        }

        override val description = "Ширина блока slides должна быть равна ширина_слайда*количество_слайдов"
    }

    private class SlidesPositionShouldBeCorrect: Expectable{
        override fun should(driver: WebDriver): Boolean {
            val slideCssSelector = "#blueimp-gallery-team div.slides div.slide"
            val slides = driver.findElements(By.cssSelector(slideCssSelector))

            for(slide in slides){
                val dataIndex = slide.getAttribute("data-index").toInt()
                val width = slide.size.width
                val left = slide.getCssValue("left")
                        .substringBefore("px").toInt()

                if (dataIndex * width != -left) {
                    return false
                }
            }

            return true
        }

        override val description = "Смещение по left должно быть  (-1)*data_index*width, где width - ширина слайдера"

    }

    private class ClickOnNextButtonShouldSwitchPhoto : Expectable {
        override fun should(driver: WebDriver): Boolean {
            val nextButtonCssSelector = "#blueimp-gallery-team > a.next"
            val slideCssSelector = "#blueimp-gallery-team div.slides div.slide"

            val nextButton = driver.findElement(By.cssSelector(nextButtonCssSelector))
            val slides = driver.findElements(By.cssSelector(slideCssSelector))

            for (slideIndex in slides.indices) {
                if (!checkSlidesLeftTransition(slideIndex, slides)) {
                    return false
                }

                nextButton.click()

                if (!checkSlidesLeftTransition((slideIndex + 1) % slides.count(), slides)) {
                    return false
                }
            }

            return true
        }

        override val description = "Нажатие на кнопку next должно переключить слайдер"

        private fun WebElement.getElementLeftTranslate(): Int {
            return this.getAttribute("style")
                        .substringAfter("translate(")
                        .substringBefore(("px,"))
                        .toInt()
        }

        private fun checkSlidesLeftTransition(currentSlideIndex: Int, slides: List<WebElement>): Boolean {
            val currentSlide = slides[currentSlideIndex]
            val prevSlide = slides[(slides.count() + currentSlideIndex - 1) % slides.count()]
            val nextSlide = slides[(slides.count() + currentSlideIndex + 1) % slides.count()]

            if (prevSlide.getElementLeftTranslate() != -prevSlide.size.width)  {
                return false
            }

            if (currentSlide.getElementLeftTranslate() != 0) {
                return false
            }

            if (nextSlide.getElementLeftTranslate() != nextSlide.size.width)  {
                return false
            }

            return true
        }

    }
}

