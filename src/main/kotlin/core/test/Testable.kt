package core.test

import core.shoulds.Shouldable

public interface Testable {
    fun addExpectation(should: Shouldable)
    fun runTest(): TestResult
}