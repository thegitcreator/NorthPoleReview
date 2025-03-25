package automation.tests;

import automation.org.example.ConfProperties;
import automation.pages.AccountPage;
import automation.pages.MainPage;
import automation.pages.TeacherLoginPage;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTeacherTest extends AbstractTest {
    public static String EMAIL = "2bhpb@indigobook.com";
    public static String PASSWORD = "pass1234";
    public static String URL = ConfProperties.getProperty("mainpage");

    public static TeacherLoginPage loginPage;
    public static AccountPage accountTeacher;
    public static MainPage mainpage;

    @BeforeMethod
    public void preconditions() {
        setUp();
        mainpage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        shoutDown();
    }

    //пишем тест
    @Test(description = "Log in as Teacher")
    public void loginTest() throws InterruptedException {
        driver.get(URL);
        mainpage.loginAsTeacherLink();

        loginPage = new TeacherLoginPage(driver);
        loginPage.inputEmail(EMAIL);
        loginPage.inputPassword(PASSWORD);
        loginPage.clickLogIn();

        accountTeacher = new AccountPage(driver);
        Assertions.assertTrue(accountTeacher.isAccountImgDisplayed(), "Элемент не найден");
        Assertions.assertTrue(accountTeacher.isDashboardDisplayed(), "Элемент не найден");
        Assertions.assertTrue(accountTeacher.isUserGreetingDisplayed(), "Элемент не найден");
        Assertions.assertTrue(accountTeacher.isLogOutButtonDisplayed(), "Элемент не найден");
    }
}
