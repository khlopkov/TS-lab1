package core.test

import core.exceptions.TestCaseException
import core.shoulds.Expectable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class TestCase : TestPreset, Testable {
    private val expectationsArr = ArrayList<Expectable>()
    val expectations: Iterable<Expectable>
            get() = this.expectationsArr
    val name: String
    val id: String

    constructor (name: String, id: String) : super() {
        this.name = name
        this.id  = id
    }
    constructor(name: String, id: String, basedOn: TestPreseted) : super(basedOn) {
        this.name = name
        this.id = id
    }

    private fun closeDriver(driver: WebDriver) {
        driver.close()
        driver.quit()
    }

    override fun addExpectation(should: Expectable) {
        this.expectationsArr.add(should)
    }

    override fun runTest(): TestResult {
        val driver: WebDriver = ChromeDriver()

        for(preaction in initialConditions) {
            try {
                preaction.`do`(driver)
            } catch (e: TestCaseException) {
                closeDriver(driver)
                return TestResult(TestStatus.Failed, preaction.description, e.failCause)
            }
        }
        for(action in actions) {
            try{
                action.`do`(driver)
            }
            catch (e: TestCaseException) {
                closeDriver(driver)
                return TestResult(TestStatus.Failed, action.description, e.failCause)
            }
        }

        for(expectation in this.expectationsArr) {
            try{
                if (!expectation.should(driver)) {
                    closeDriver(driver)
                    return TestResult(TestStatus.Failed, expectation.description, "false")
                }
            }
            catch (e: TestCaseException) {
                closeDriver(driver)
                return TestResult(TestStatus.Failed, expectation.description, e.failCause)
            }
        }

        for(afterAction in afterTestActions) {
            try{
                afterAction.`do`(driver)
            }
            catch (e: TestCaseException) {
                closeDriver(driver)
                return TestResult(TestStatus.Failed, afterAction.description, e.failCause)
            }
        }

        closeDriver(driver)
        return TestResult(TestStatus.Passed, this.name)
    }
}