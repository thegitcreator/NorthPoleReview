package automation.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TeacherLoginPage {
    private static final By EMAIL_FIELD = By.name("email");
    private static final By PASSWORD_FIELD = By.name("password");
    private static final String LOG_IN_IMG = "//img[@src='/images/account/button_login.gif']";

    private final WebDriver driver;

    public TeacherLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Enter email")
    public void inputEmail(String email){
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }

    @Step("Enter password")
    public void inputPassword(String password){
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    @Step("Click Log in button")
    public void clickLogIn(){
        driver.findElement(By.xpath(LOG_IN_IMG)).click();
    }

}
