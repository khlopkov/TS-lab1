package core.test

import core.actions.Actionable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.*

public open class TestPreset : TestPresetable, TestPreseted {
    protected val preactionsArr = ArrayList<Actionable>()
    protected val actionsArr = ArrayList<Actionable>()
    protected val afterTestActionsArr = ArrayList<Actionable>()

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