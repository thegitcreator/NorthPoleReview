package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private static final By accountImg = By.xpath("//img[@class='title' and @src='/images/account/title.jpg']");
    private static final By accountDashboard = By.xpath("//table[@class='dash']");
    private static final By userGreeting = By.xpath("//h1[contains(text(), 'Hello, ') " +
            "and contains(., '! What would you like to do?')]");
    private static final By logOutButton = By.xpath("//a[contains(text(), 'Log Out')]");

    private final WebDriver driver;

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean isAccountImgDisplayed(){
        WebElement result = driver.findElement(accountImg);
        return result.isDisplayed();
    }

    public Boolean isDashboardDisplayed(){
        WebElement result = driver.findElement(accountDashboard);
        return result.isDisplayed();
    }

    public Boolean isUserGreetingDisplayed(){
        WebElement result = driver.findElement(userGreeting);
        return result.isDisplayed();
    }

    public Boolean isLogOutButtonDisplayed(){
        WebElement result = driver.findElement(logOutButton);
        return result.isDisplayed();
    }

}
