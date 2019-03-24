package core.shoulds
import org.openqa.selenium.WebDriver

public interface Shouldable {
    val description: String
    fun should(driver: WebDriver): Boolean
}