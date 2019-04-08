package core.exceptions

import java.lang.Exception

public open class TestCaseException(val failCause: String) : Exception(
        "Test failed because $failCause"
) { }