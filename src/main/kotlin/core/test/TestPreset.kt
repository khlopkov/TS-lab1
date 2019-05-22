package core.test

import core.actions.Actionable
import java.util.*

open class TestPreset() : TestPresetable, TestPreseted {
    private val initialConditionsArr = ArrayList<Actionable>()
    private val actionsArr = ArrayList<Actionable>()
    private val afterTestActionsArr = ArrayList<Actionable>()

    constructor(basedOn: TestPreseted) : this (){
        for(initialCondition in basedOn.initialConditions) {
            this.initialConditionsArr.add(initialCondition)
        }

        for(action in basedOn.actions) {
            this.actionsArr.add(action)
        }

        for(afterTestAction in basedOn.afterTestActions) {
            this.afterTestActionsArr.add(afterTestAction)
        }
    }

    override val initialConditions: Iterable<Actionable>
        get() = this.initialConditionsArr

    override val actions: Iterable<Actionable>
        get () = this.actionsArr

    override val afterTestActions: Iterable<Actionable>
        get() = this.afterTestActionsArr

    override fun addInitialCondition(action: Actionable) {
        this.initialConditionsArr.add(action)
    }

    override fun addAction(action: Actionable) {
        this.actionsArr.add(action)
    }

    override fun addAfterTest(action: Actionable) {
        this.afterTestActionsArr.add(action)
    }
}