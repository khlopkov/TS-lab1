import core.elements.ElementByXpath
import core.shoulds.ElementShould
import core.shoulds.ElementShouldExist
import core.shoulds.TitleShould
import core.test.TestCase
import presets.DropdownListIdentifier
import presets.NavBarLink
import presets.FooterLink
import presets.NavLinkClickPreset
import presets.FooterLinkClickPreset
import scenario.HtmlReportGenerator
import test.creators.*
import java.io.FileWriter

fun main(args: Array<String>) {
    val testList = mutableListOf<TestCase>()

    // testList.add(testNavbarStaffLink())
    // testList.add(testNavbarAchievementsLink())
    // testList.add(testNavbarNewsLink())
    // testList.add(testNavbarProjectsLink())
    // testList.add(testNavbarFilesLink())
    // testList.add(testNavbarMediaLink())
    // testList.add(testNavbarInformationLink())
    // testList.add(testNavbarPartnersLink())
    // testList.add(testDropdownStudentClubs())
    // testList.add(testDropdownFaculties())
    // testList.add(testStudsDropdownAboutLink())
    // testList.add(testStudsDropdownCreateClubLink())
    // testList.add(testStudsDropdownMentoringLink())
    // testList.add(testStudsDropdownFilesLink())
    // testList.add(testStudsDropdownForLeaderLink())
    // testList.add(testStudsDropdownClubsLink())
    // testList.add(testFacultiesDropdownIktLink())
    // testList.add(testFacultiesDropdownFtmiLink())
    // testList.add(testIktAboutUsSidebarLink())
    // testList.add(testIktFilesSidebarLink())
    // testList.add(testIktStaffSidebarLink())
    // testList.add(testFtmiAboutUsSidebarLink())
    // testList.add(testFtmiStaffSidebarLink())
    // testList.add(testStaffSlider())
    //testList.add(testFooterStaffLink())
    //testList.add(testFooterAchievementsLink())
    //testList.add(testFooterNewsLink())
    //testList.add(testFooterProjectsLink())
    // testList.add(testFooterFilesLink())
    // testList.add(testFooterMediaLink())
    // testList.add(testFooterInformationLink())
    // testList.add(testFooterPartnersLink())
    // testList.add(testSearch())
    // testList.add(testClickNextOnBottomSliderOnMainPage())
    // testList.add(testClickPrevOnBottomSliderOnMainPage())
    // testList.add(testAllNewsClick())
    testList.add(testDepartmentBottomLinkClick())
    testList.add(testForumsBottomLinkClick())
    testList.add(testStudsUnionDevelopmentBottomLinkClick())
    testList.add(testInfrastructureBottomLinkClick())

    val reporter = HtmlReportGenerator()
    val writer = FileWriter("report.html")
    reporter.generateReport(testList)?.render(writer)

    for(test in testList) {
        println(test.runTest().message)
    }
}

private const val PageHeaderXPath: String = "//h2[contains(@class, 'page-header')]"
private const val PageH4SubheaderXPath: String = "//h4[contains(@class, 'page-sub-header')]"
private const val PageH3SubheaderXPath: String = "//h3[contains(@class, 'page-sub-header')]"

fun testNavbarStaffLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку состав в navbar", "testStaffLink", NavLinkClickPreset(NavBarLink.Staff))

    testCase.addExpectation(TitleShould(
            "содержать \"Состав Совет обучающихся Совет обучающихся университета ИТМО\""
    ) { it.contains("Состав Совет обучающихся Совет обучающихся университета ИТМО", true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать слово Состав",
            ElementByXpath(PageHeaderXPath)
    ) { it.text == "Состав" })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH4SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать \"Совет обучающихся\"",
            ElementByXpath(PageH4SubheaderXPath)
    ) { it.text.contains("Совет обучающихся", true) })

    return testCase
}

fun testNavbarAchievementsLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку Достижения в navbar", "testNavbarAchievementsLink", NavLinkClickPreset(NavBarLink.Achievements))

    testCase.addExpectation(TitleShould(
            "содержать \"Совет обучающихся университета ИТМО\""
    ) { it.contains("Совет обучающихся университета ИТМО", true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать слово Достижения",
            ElementByXpath(PageHeaderXPath)
    ) { it.text == "Достижения" })

    return testCase
}

fun testNavbarNewsLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку новости в navbar","testNavbarNewsLink",  NavLinkClickPreset(NavBarLink.News))

    testCase.addExpectation(TitleShould(
            "содержать \"Новости Совет обучающихся Университета ИТМО\""
    ) { it.contains("Новости Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH3SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать \"Новости\"",
            ElementByXpath(PageH3SubheaderXPath)
    ) { it.text.contains("Новости", true) })

    return testCase
}

fun testNavbarProjectsLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку Проекты в navbar", "testNavbarProjectsLink", NavLinkClickPreset(NavBarLink.Projects))

    testCase.addExpectation(TitleShould(
            "содержать \"Проекты Совет обучающихся Университета ИТМО\""
    ) { it.contains("Проекты Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShould(
            "содержать Проекты",
            ElementByXpath(PageHeaderXPath)
    ) { it.text.contains("Проекты", true) })

    return testCase
}

fun testNavbarFilesLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку Файлы в navbar", "testNavbarFilesLink", NavLinkClickPreset(NavBarLink.Files))

    testCase.addExpectation(TitleShould(
            "содержать \"Файлы Совет обучающихся Совет обучающихся Университета ИТМО\""
    ) { it.contains("Файлы Совет обучающихся Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать \"Файлы\"",
            ElementByXpath(PageHeaderXPath)
    ) { it.text.contains("Файлы", true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH4SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать \"Совет обучающихся\"",
            ElementByXpath(PageH4SubheaderXPath)
    ) { it.text.contains("Совет обучающихся", true) })

    return testCase
}

fun testNavbarMediaLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку Медиа в navbar", "testNavbarMediaLink", NavLinkClickPreset(NavBarLink.Media))

    testCase.addExpectation(TitleShould(
            "содержать \"Медиа Совет обучающихся Университета ИТМО\""
    ) { it.contains("Медиа Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH4SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать \"Медиа\"",
            ElementByXpath(PageH4SubheaderXPath)
    ) { it.text.contains("Медиа", true) })

    return testCase
}

fun testNavbarInformationLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку информация в navbar", "testNavbarInformationLink", NavLinkClickPreset(NavBarLink.Info))

    testCase.addExpectation(TitleShould(
            "содержать \"Совет обучающихся Университета ИТМО\""
    ) { it.contains("Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать \"Полезная информация\"",
            ElementByXpath(PageHeaderXPath)
    ) { it.text.contains("Полезная информация", true) })

    return testCase
}

fun testNavbarPartnersLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку Партнеры в navbar", "testNavbarPartnersLink", NavLinkClickPreset(NavBarLink.Partners))

    testCase.addExpectation(TitleShould(
            "содержать \"Партнеры Совет обучающихся Совет обучающихся Университета ИТМО\""
    ) { it.contains("Партнеры Совет обучающихся Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH3SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать \"Партнёры\"",
            ElementByXpath(PageH3SubheaderXPath)
    ) { it.text.contains("Партнёры", true) })

    return testCase
}

fun testDropdownStudentClubs(): TestCase {
    val testCaseCreator = ClickDropdownTestCaseCreator(DropdownListIdentifier.StudentsClubList, "testDropdownStudentClubs")
    return testCaseCreator.testCase
}

fun testDropdownFaculties(): TestCase {
    val testCaseCreator = ClickDropdownTestCaseCreator(DropdownListIdentifier.FacultiesList, "testDropdownFaculties")
    return testCaseCreator.testCase
}

fun testStudsDropdownAboutLink(): TestCase {
    val testCaseCreator = StudsDropdownLinksClickTestCaseCreator(StudsDropdownLink.AboutClubSystem, "testStudsDropdownAboutLink")
    return testCaseCreator.testCase
}

fun testStudsDropdownCreateClubLink(): TestCase {
    val testCaseCreator = StudsDropdownLinksClickTestCaseCreator(StudsDropdownLink.ClubCreation, "testStudsDropdownCreateClubLink")
    return testCaseCreator.testCase
}

fun testStudsDropdownMentoringLink(): TestCase {
    val testCaseCreator = StudsDropdownLinksClickTestCaseCreator(StudsDropdownLink.ClubMentoring, "testStudsDropdownMentoringLink")
    return testCaseCreator.testCase
}

fun testStudsDropdownFilesLink(): TestCase {
    val testCaseCreator = StudsDropdownLinksClickTestCaseCreator(StudsDropdownLink.FilesAndInstructions, "testStudsDropdownFilesLink")
    return testCaseCreator.testCase
}

fun testStudsDropdownForLeaderLink(): TestCase {
    val testCaseCreator = StudsDropdownLinksClickTestCaseCreator(StudsDropdownLink.ForClubLeader, "testStudsDropdownForLeaderLink")
    return testCaseCreator.testCase
}

fun testStudsDropdownClubsLink(): TestCase {
    val testCaseCreator = StudsDropdownLinksClickTestCaseCreator(StudsDropdownLink.Clubs, "testStudsDropdownClubsLink")
    return testCaseCreator.testCase
}

fun testFacultiesDropdownIktLink(): TestCase {
    return FacultiesDropdownLinksTestCaseCreator(FacultiesDropdownLink.IKT, "testFacultiesDropdownIktLink").testCase
}

fun testFacultiesDropdownFtmiLink(): TestCase {
    val testCaseCreator = FacultiesDropdownLinksTestCaseCreator(FacultiesDropdownLink.FTMI, "testFacultiesDropdownFtmiLink")
    return testCaseCreator.testCase
}

fun testIktAboutUsSidebarLink(): TestCase {
    val testCaseCreator = FacultiesSidebarLinksTestCaseCreator(FacultiesDropdownLink.IKT, FacultiesSidebarLink.AboutUs, "testIktAboutUsSidebarLink")
    return testCaseCreator.testCase
}

fun testIktStaffSidebarLink(): TestCase {
    val testCaseCreator = FacultiesSidebarLinksTestCaseCreator(FacultiesDropdownLink.IKT, FacultiesSidebarLink.Staff, "testIktStaffSidebarLink")
    return testCaseCreator.testCase
}

fun testIktFilesSidebarLink(): TestCase {
    val testCaseCreator = FacultiesSidebarLinksTestCaseCreator(FacultiesDropdownLink.IKT, FacultiesSidebarLink.Files, "testIktFilesSidebarLink")
    return testCaseCreator.testCase
}

fun testFtmiAboutUsSidebarLink(): TestCase {
    val testCaseCreator = FacultiesSidebarLinksTestCaseCreator(FacultiesDropdownLink.FTMI, FacultiesSidebarLink.AboutUs, "testFtmiAboutUsSidebarLink")
    return testCaseCreator.testCase
}

fun testFtmiStaffSidebarLink(): TestCase {
    val testCaseCreator = FacultiesSidebarLinksTestCaseCreator(FacultiesDropdownLink.FTMI, FacultiesSidebarLink.Staff, "testFtmiStaffSidebarLink")
    return testCaseCreator.testCase
}

fun testStaffSlider(): TestCase {
    val testCaseCreator = ClickSliderTestCaseCreator("testStaffSlider")
    return testCaseCreator.testCase
}

fun testFooterStaffLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку состав в footer", "testFooterStaffLink", FooterLinkClickPreset(FooterLink.Staff))

    testCase.addExpectation(TitleShould(
            "содержать \"Состав Совет обучающихся Совет обучающихся университета ИТМО\""
    ) { it.contains("Состав Совет обучающихся Совет обучающихся университета ИТМО", true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать слово Состав",
            ElementByXpath(PageHeaderXPath)
    ) { it.text == "Состав" })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH4SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать \"Совет обучающихся\"",
            ElementByXpath(PageH4SubheaderXPath)
    ) { it.text.contains("Совет обучающихся", true) })

    return testCase
}

fun testFooterAchievementsLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку Достижения в footer", "testFooterAchievementsLink", FooterLinkClickPreset(FooterLink.Achievements))

    testCase.addExpectation(TitleShould(
            "содержать \"Совет обучающихся университета ИТМО\""
    ) { it.contains("Совет обучающихся университета ИТМО", true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать слово Достижения",
            ElementByXpath(PageHeaderXPath)
    ) { it.text == "Достижения" })

    return testCase
}

fun testFooterNewsLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку новости в footer","testFooterNewsLink",  FooterLinkClickPreset(FooterLink.News))

    testCase.addExpectation(TitleShould(
            "содержать \"Новости Совет обучающихся Университета ИТМО\""
    ) { it.contains("Новости Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH3SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать \"Новости\"",
            ElementByXpath(PageH3SubheaderXPath)
    ) { it.text.contains("Новости", true) })

    return testCase
}

fun testFooterProjectsLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку Проекты в footer", "testFooterProjectsLink", FooterLinkClickPreset(FooterLink.Projects))

    testCase.addExpectation(TitleShould(
            "содержать \"Проекты Совет обучающихся Университета ИТМО\""
    ) { it.contains("Проекты Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShould(
            "содержать Проекты",
            ElementByXpath(PageHeaderXPath)
    ) { it.text.contains("Проекты", true) })

    return testCase
}

fun testFooterFilesLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку Файлы в footer", "testFooterFilesLink", FooterLinkClickPreset(FooterLink.Files))

    testCase.addExpectation(TitleShould(
            "содержать \"Файлы Совет обучающихся Совет обучающихся Университета ИТМО\""
    ) { it.contains("Файлы Совет обучающихся Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать \"Файлы\"",
            ElementByXpath(PageHeaderXPath)
    ) { it.text.contains("Файлы", true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH4SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать \"Совет обучающихся\"",
            ElementByXpath(PageH4SubheaderXPath)
    ) { it.text.contains("Совет обучающихся", true) })

    return testCase
}

fun testFooterMediaLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку Медиа в footer", "testFooterMediaLink", FooterLinkClickPreset(FooterLink.Media))

    testCase.addExpectation(TitleShould(
            "содержать \"Медиа Совет обучающихся Университета ИТМО\""
    ) { it.contains("Медиа Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH4SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать \"Медиа\"",
            ElementByXpath(PageH4SubheaderXPath)
    ) { it.text.contains("Медиа", true) })

    return testCase
}

fun testFooterInformationLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку информация в footer", "testFooterInformationLink", FooterLinkClickPreset(FooterLink.Info))

    testCase.addExpectation(TitleShould(
            "содержать \"Совет обучающихся Университета ИТМО\""
    ) { it.contains("Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageHeaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать \"Полезная информация\"",
            ElementByXpath(PageHeaderXPath)
    ) { it.text.contains("Полезная информация", true) })

    return testCase
}

fun testFooterPartnersLink(): TestCase {
    val testCase = TestCase("Нажатие на ссылку Партнеры в footer", "testFooterPartnersLink", FooterLinkClickPreset(FooterLink.Partners))

    testCase.addExpectation(TitleShould(
            "содержать \"Партнеры Совет обучающихся Совет обучающихся Университета ИТМО\""
    ) { it.contains("Партнеры Совет обучающихся Совет обучающихся Университета ИТМО" , true) })

    testCase.addExpectation(ElementShouldExist(ElementByXpath(PageH3SubheaderXPath)))
    testCase.addExpectation(ElementShould(
            "содержать \"Партнёры\"",
            ElementByXpath(PageH3SubheaderXPath)
    ) { it.text.contains("Партнёры", true) })

    return testCase
}

fun testSearch(): TestCase {
    return SearchTestCaseCreator("testSearch").testCase
}

fun testClickNextOnBottomSliderOnMainPage(): TestCase {
    return BottomSliderTestCreator(BottomSliderDirection.Next, "testClickNextOnBottomSliderOnMainPage").testCase
}

fun testClickPrevOnBottomSliderOnMainPage(): TestCase {
    return BottomSliderTestCreator(BottomSliderDirection.Previous, "testClickPrevOnBottomSliderOnMainPage").testCase
}

fun testAllNewsClick(): TestCase {
    return AllNewsClickTestCaseCreator("testAllNewsClick").testCase
}

fun testDepartmentBottomLinkClick(): TestCase {
    return BottomLinksTestCreator("testDepartmentBottomLinkClick", BottomLink.Department).testCase
}

fun testForumsBottomLinkClick(): TestCase {
    return BottomLinksTestCreator("testForumsBottomLinkClick", BottomLink.Forums).testCase
}

fun testStudsUnionDevelopmentBottomLinkClick(): TestCase {
    return BottomLinksTestCreator("testStudsUnionDevelopmentBottomLinkClick", BottomLink.StudsUnionDevelopment).testCase
}

fun testInfrastructureBottomLinkClick(): TestCase {
    return BottomLinksTestCreator("testInfrastructureBottomLinkClick", BottomLink.Infrastructure).testCase
}
