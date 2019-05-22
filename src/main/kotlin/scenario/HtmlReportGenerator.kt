package scenario

import core.actions.Actionable
import core.shoulds.Expectable
import core.test.TestCase
import j2html.TagCreator.*
import j2html.tags.ContainerTag

class HtmlReportGenerator : HtmlReportable {
    override fun generateReport(tests: Iterable<TestCase>): ContainerTag? {
        var tables = tests.map {
            div(
                h2(it.id),
                this.testTable(it)
            )
        }
        return html(
                head(link().withRel("stylesheet").withHref("styles.css")),
                body(
                    *tables.toTypedArray()
                )
        )
    }

    private fun initialConditionsRow(conditions: Iterable<Actionable>): ContainerTag? {
        var lis = conditions.mapIndexed {
            i, a ->
            if (i == 0) li(a.description) else li("и " + a.description)
        }
        var ul = ul(*lis.toTypedArray())
        return tr(
            td("Дано").withClass("keyword-col"),
            td(ul).withClass("description-col")
        )
    }

    private fun actionsRow(actions: Iterable<Actionable>): ContainerTag? {
        var lis = actions.mapIndexed {
            i, a ->
            if (i == 0) li(a.description) else li("и " + a.description)
        }
        var ul = ul(*lis.toTypedArray())
        return tr(
                td("Когда").withClass("keyword-col"),
                td(ul).withClass("description-col")
        )
    }

    private fun expectationsRow(expectations: Iterable<Expectable>): ContainerTag? {
        var lis = expectations.mapIndexed {
            i, a ->
            if (i == 0) li(a.description) else li("и " + a.description)
        }
        var ul = ul(*lis.toTypedArray())
        return tr(
                td("Тогда").withClass("keyword-col"),
                td(ul).withClass("description-col")
        )
    }

    private fun testTable(testCase: TestCase): ContainerTag? {
        return table(
            tr(
                td("Ключевое слово").withClass("keyword-col"),
                td("Описание").withClass("description-col")
            ),
                tr(
                        td("Сценарий").withClass("keyword-col"),
                        td(testCase.name).withClass("description-col")
                ),
            initialConditionsRow(testCase.initialConditions),
            actionsRow(testCase.actions),
            expectationsRow(testCase.expectations)
        )
    }
}

