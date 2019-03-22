import org.openqa.selenium.chrome.ChromeDriver;

fun main(args: Array<String>) {
	println("Hello world")
	val driver = ChromeDriver();
	driver.get("https://student.ifmo.ru")
	val el = driver.findElementByTagName("body");
	println(el.text);
}
