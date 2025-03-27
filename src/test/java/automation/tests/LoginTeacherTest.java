package automation.tests;

import automation.org.example.ConfProperties;
import automation.pages.AccountPage;
import automation.pages.MainPage;
import automation.pages.TeacherLoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTeacherTest extends AbstractTest {
    public static String EMAIL = ConfProperties.getEmail();
    public static String PASSWORD = ConfProperties.getPassword();
    public static String URL = ConfProperties.getProperty("mainpage");

    public static TeacherLoginPage loginPage;
    public static AccountPage accountTeacher;
    public static MainPage mainpage;

    @BeforeMethod
    public void preconditions() {
        setUp();
        mainpage = new MainPage(driver);
        loginPage = new TeacherLoginPage(driver);
        accountTeacher = new AccountPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        shoutDown();
    }

    @Test(description = "Log in as Teacher")
    public void loginTest() throws InterruptedException {
        mainpage.loginAsTeacherLink();

        loginPage.inputEmail(EMAIL)
                .inputPassword(PASSWORD)
                .clickLogIn();

        assertTrue(accountTeacher.isAccountImgDisplayed(), "Не найдено основной картинки на странице аккаунта");
        assertTrue(accountTeacher.isDashboardDisplayed(), "Дашборд на странице аккаунта не найден");
        assertTrue(accountTeacher.isUserGreetingDisplayed(), "Текст приветствия юзера не найден");
        assertTrue(accountTeacher.isLogOutButtonDisplayed(), "Ссылка на выход из аккаунта не найдена");
    }
}