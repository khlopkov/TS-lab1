package scenario

import core.test.TestCase
import j2html.tags.ContainerTag

interface HtmlReportable {
    fun generateReport(tests: Iterable<TestCase>): ContainerTag?
}