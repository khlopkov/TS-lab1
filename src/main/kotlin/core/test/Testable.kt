package core.test

import core.shoulds.Expectable

interface Testable {
    fun addExpectation(should: Expectable)
    fun runTest(): TestResult
}