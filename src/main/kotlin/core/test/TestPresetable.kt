package core.test

import core.actions.Actionable

public interface TestPresetable {
    fun addPreaction(action: Actionable)
    fun addAction(action: Actionable)
    fun addAfterTest(action: Actionable)
}

public interface TestPreseted {
    val preactions: Iterable<Actionable>
    val actions: Iterable<Actionable>
    val afterTestActions: Iterable<Actionable>
}