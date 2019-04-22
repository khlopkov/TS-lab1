package core.shoulds

import org.openqa.selenium.WebDriver

interface NamedExpectable : Expectable {
    val name: String
}

class NamedShould(override val name: String, private val should: Expectable) : NamedExpectable, Expectable {
    override val description: String
        get() = this.should.description

    override fun should(driver: WebDriver): Boolean {
        return this.should.should(driver)
    }
}
