package core.test

import core.exceptions.TestCaseException
import core.shoulds.Shouldable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

public class TestCase : TestPreset, Testable {
    private val expectationsArr = ArrayList<Shouldable>()
    val name: String
    public constructor (name: String) : super() { this.name = name }
    public constructor(name: String, basedOn: TestPreseted) : super(basedOn) { this.name = name }

    override fun addExpectation(should: Shouldable) {
        this.expectationsArr.add(should)
    }

    override fun runTest(): TestResult {
        val driver: WebDriver = ChromeDriver()

        for(preaction in preactions) {
            try{
                preaction.Do(driver)
            }
            catch (e: TestCaseException) {
                return TestResult(TestStatus.Failed, preaction.description, e.failCause)
            }
          for(action in actionsArr) {
            try{
                action.Do(driver)
            }
            catch (e: TestCaseException) {
                return TestResult(TestStatus.Failed, action.description, e.failCause)
            }
        }      }

        for(action in actions) {
            try{
                action.Do(driver)
            }
            catch (e: TestCaseException) {
                return TestResult(TestStatus.Failed, action.description, e.failCause)
            }
        }

        for(expectation in this.expectationsArr) {
            try{
                if (!expectation.should(driver)) {
                    return TestResult(TestStatus.Failed, expectation.description, "false")
                }
            }
            catch (e: TestCaseException) {
                return TestResult(TestStatus.Failed, expectation.description, e.failCause)
            }
        }

        for(afterAction in afterTestActions) {
            try{
                afterAction.Do(driver)
            }
            catch (e: TestCaseException) {
                return TestResult(TestStatus.Failed, afterAction.description, e.failCause)
            }
        }

        driver.close()
        driver.quit()

        return TestResult(TestStatus.Passed, this.name)
    }
}