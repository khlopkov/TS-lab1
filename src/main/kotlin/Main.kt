import core.actions.Click
import core.actions.DriverAction
import core.actions.GetUrl
import core.elements.ElementByXpath
import core.test.TestCase

fun main(args: Array<String>) {
    var testCase = TestCase("test1")
    testCase.addPreaction(GetUrl("https://student.ifmo.ru"))
    testCase.addAction(Click(ElementByXpath("//nav[contains(@class, 'navbar')]//a[1]")))
    testCase.addAfterTest(DriverAction("close test", { it.close() }))
    println(testCase.runTest().message)
}
