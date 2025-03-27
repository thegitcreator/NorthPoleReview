package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    private static final By ACCOUNT_IMG = By.xpath("//img[@class='title' and @src='/images/account/title.jpg']");
    private static final By ACCOUNT_DASHBOARD = By.xpath("//table[@class='dash']");
    private static final By USER_GREETING = By.xpath("//h1[text()='! What would you like to do?']");
    private static final By LOG_OUT_LINK = By.xpath("//a[contains(text(), 'Log Out')]");

    private final WebDriver driver;

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean isAccountImgDisplayed(){
        WebElement result = driver.findElement(ACCOUNT_IMG);
        return result.isDisplayed();
    }

    public Boolean isDashboardDisplayed(){
        WebElement result = driver.findElement(ACCOUNT_DASHBOARD);
        return result.isDisplayed();
    }

    public Boolean isUserGreetingDisplayed(){
        WebElement result = driver.findElement(USER_GREETING);
        return result.isDisplayed();
    }

    public Boolean isLogOutButtonDisplayed(){
        WebElement result = driver.findElement(LOG_OUT_LINK);
        return result.isDisplayed();
    }
}