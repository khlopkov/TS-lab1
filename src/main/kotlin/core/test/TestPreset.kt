package core.test

import core.actions.Actionable
import java.util.*

public open class TestPreset() : TestPresetable, TestPreseted {
    protected val preactionsArr = ArrayList<Actionable>()
    protected val actionsArr = ArrayList<Actionable>()
    protected val afterTestActionsArr = ArrayList<Actionable>()

    public constructor(basedOn: TestPreseted) : this (){
        for(preaction in basedOn.preactions) {
            this.preactionsArr.add(preaction)
        }

        for(action in basedOn.actions) {
            this.actionsArr.add(action)
        }

        for(afterTestAction in basedOn.afterTestActions) {
            this.afterTestActionsArr.add(afterTestAction)
        }
    }

    override val preactions: Iterable<Actionable>
        get() = this.preactionsArr

    override val actions: Iterable<Actionable>
        get () = this.actionsArr

    override val afterTestActions: Iterable<Actionable>
        get() = this.afterTestActionsArr

    override fun addPreaction(action: Actionable) {
        this.preactionsArr.add(action)
    }

    override fun addAction(action: Actionable) {
        this.actionsArr.add(action)
    }

    override fun addAfterTest(action: Actionable) {
        this.afterTestActionsArr.add(action)
    }
}