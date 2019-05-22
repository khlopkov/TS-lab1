package core.test

import core.actions.Actionable

interface TestPresetable {
    fun addInitialCondition(action: Actionable)
    fun addAction(action: Actionable)
    fun addAfterTest(action: Actionable)
}

interface TestPreseted {
    val initialConditions: Iterable<Actionable>
    val actions: Iterable<Actionable>
    val afterTestActions: Iterable<Actionable>
}