package core.shoulds

import org.openqa.selenium.WebDriver

public interface NamedShouldable : Shouldable {
    public val name: String
}

public class NamedShould(override val name: String, private val should: Shouldable) : NamedShouldable {
    override val description: String
        get() = this.should.description

    override fun should(driver: WebDriver): Boolean {
        return this.should.should(driver)
    }
}
