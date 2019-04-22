package core.shoulds

import org.openqa.selenium.WebDriver

interface NamedShouldable : Shouldable {
    val name: String
}

class NamedShould(override val name: String, private val should: Shouldable) : NamedShouldable, Shouldable {
    override val description: String
        get() = this.should.description

    override fun should(driver: WebDriver): Boolean {
        return this.should.should(driver)
    }
}
