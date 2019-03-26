package core.shoulds

import core.actions.Actionable

abstract class AbstractShould : Shouldable {
    override fun then(action: Actionable): Shouldable {
        return ShouldWithAfteraction(this, action)
    }
}