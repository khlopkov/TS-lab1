package scenario

interface DescribedScenario{
    val scenario: String
    val given: Iterable<String>
    val when_: Iterable<String>
    val then: Iterable<String>
}