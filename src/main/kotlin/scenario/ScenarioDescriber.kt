package scenario

import core.test.TestCase

class ScenarioDescriber(testCase: TestCase) : DescribedScenario {
    override val scenario: String = testCase.name
    override val given: Iterable<String> = testCase.initialConditions.map { it.description }
    override val when_: Iterable<String> = testCase.actions.map { it.description }
    override val then: Iterable<String> = testCase.expectations.map { it.description }
}