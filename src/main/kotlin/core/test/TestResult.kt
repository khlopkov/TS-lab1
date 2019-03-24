package core.test

public enum class TestStatus {
    Failed,
    Passed,
    Skipped
}

public class TestResult(val testStatus: TestStatus, val when_: String, val cause: String = "") {
    val message: String
        get() {
             when (this.testStatus) {
                 TestStatus.Failed -> return "Test failed, when: ${this.when_}, because: ${this.cause}"
                 TestStatus.Passed -> return "Test passed, when: ${this.when_}"
                 TestStatus.Skipped -> return "Test skipped, when: ${this.when_}"
            }
        }
}