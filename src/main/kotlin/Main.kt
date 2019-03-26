import core.elements.ElementByXpath
import core.shoulds.ElementShould
import core.shoulds.ElementShouldExist
import core.shoulds.TitleShould
import core.test.TestCase
import presets.NavBarLink
import presets.NavLinkClickPreset

fun main(args: Array<String>) {
    // testNavbarStaffLink()
    // testNavbarAchievementsLink()
    // testNavbarNewsLink()
    // testNavbarProjectsLink()
    // testNavbarFilesLink()
    // testNavbarMediaLink()
    // testNavbarInformationLink()
    testNavbarPartnersLink()
}

private val PageHeaderXPath: String = "//h2[contains(@class, 'page-header')]"
private val PageH4SubheaderXPath: String = "//h4[contains(@class, 'page-sub-header')]"
private val PageH3SubheaderXPath: String = "//h3[contains(@class, 'page-sub-header')]"

fun testNavbarStaffLink() {
    val testCase = TestCase("testStaffLink", NavLinkClickPreset(NavBarLink.Staff))

    testCase.addExpectation(TitleShould(
            "Состав Совет обучающихся Совет обучающихся университета ИТМО"
    ) { it.contains("Состав Совет обучающихся Совет обучающихся университета ИТМО", true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать слово Состав",
            ElementByXpath(PageHeaderXPath)
    ) { it.text == "Состав" })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH4SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать Совет обучающихся",
            ElementByXpath(PageH4SubheaderXPath)
    ) { it.text.contains("Совет обучающихся", true) })

    val message = testCase.runTest().message
    println(message)
}

fun testNavbarAchievementsLink() {
    val testCase = TestCase("testAchievementsLink", NavLinkClickPreset(NavBarLink.Achievements))

    testCase.addExpectation(TitleShould(
            "Совет обучающихся университета ИТМО"
    ) { it.contains("Совет обучающихся университета ИТМО", true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать слово Достижения",
            ElementByXpath(PageHeaderXPath)
    ) { it.text == "Достижения" })

    val message = testCase.runTest().message
    println(message)
}

fun testNavbarNewsLink() {
    val testCase = TestCase("testNewsLink", NavLinkClickPreset(NavBarLink.News))

    testCase.addExpectation(TitleShould(
            "Новости Совет обучающихся Университета ИТМО"
    ) { it.contains("Новости Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH3SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать Новости",
            ElementByXpath(PageH3SubheaderXPath)
    ) { it.text.contains("Новости", true) })

    val message = testCase.runTest().message
    println(message)
}

fun testNavbarProjectsLink() {
    val testCase = TestCase("testProjectLink", NavLinkClickPreset(NavBarLink.Projects))

    testCase.addExpectation(TitleShould(
            "Проекты Совет обучающихся Университета ИТМО"
    ) { it.contains("Проекты Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShould(
            "содержать Проекты",
            ElementByXpath(PageHeaderXPath)
    ) { it.text.contains("Проекты", true) })

    val message = testCase.runTest().message
    println(message)
}

fun testNavbarFilesLink() {
    val testCase = TestCase("testFilesLink", NavLinkClickPreset(NavBarLink.Files))

    testCase.addExpectation(TitleShould(
            "Файлы Совет обучающихся Совет обучающихся Университета ИТМО"
    ) { it.contains("Файлы Совет обучающихся Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать Файлы",
            ElementByXpath(PageHeaderXPath)
    ) { it.text.contains("Файлы", true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH4SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать Совет обучающихся",
            ElementByXpath(PageH4SubheaderXPath)
    ) { it.text.contains("Совет обучающихся", true) })

    val message = testCase.runTest().message
    println(message)
}

fun testNavbarMediaLink() {
    val testCase = TestCase("testMediaLink", NavLinkClickPreset(NavBarLink.Media))

    testCase.addExpectation(TitleShould(
            "Медиа Совет обучающихся Университета ИТМО"
    ) { it.contains("Медиа Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH4SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать Медиа",
            ElementByXpath(PageH4SubheaderXPath)
    ) { it.text.contains("Медиа", true) })

    val message = testCase.runTest().message
    println(message)
}

fun testNavbarInformationLink() {
    val testCase = TestCase("testInformationLink", NavLinkClickPreset(NavBarLink.Info))

    testCase.addExpectation(TitleShould(
            "Совет обучающихся Университета ИТМО"
    ) { it.contains("Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать Полезная информация",
            ElementByXpath(PageHeaderXPath)
    ) { it.text.contains("Полезная информация", true) })

    val message = testCase.runTest().message
    println(message)
}

fun testNavbarPartnersLink() {
    val testCase = TestCase("testPartnersLink", NavLinkClickPreset(NavBarLink.Partners))

    testCase.addExpectation(TitleShould(
            "Партнеры Совет обучающихся Совет обучающихся Университета ИТМО"
    ) { it.contains("Партнеры Совет обучающихся Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH3SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать Партнёры",
            ElementByXpath(PageH3SubheaderXPath)
    ) { it.text.contains("Партнёры", true) })

    val message = testCase.runTest().message
    println(message)
}
