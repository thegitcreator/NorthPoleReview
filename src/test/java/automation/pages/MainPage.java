package automation.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private static final By HOLIDAY_BREADS = By.xpath("//a[contains(text(),'Holiday Breads')]");
    private static final By TEACHER_LOG_IN = By.xpath("//a[contains(text(), 'Teacher') " +
            "and @href='/Account/login.asp?teacher']");
    private static final By RAYMOND_BUNDLE_LINK = By.xpath("//a[@class='home-btn' and @href='/ReindeerBarn/raymond-bundle/']");

    protected final WebDriver driver;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
       this.driver = driver;
    }

    @Step("Find and click 'Holiday Breads' link")
    public void breadsLink(){
        driver.findElement(HOLIDAY_BREADS).click();
    }

    @Step("Click on 'Log in as teacher' link")
    public void loginAsTeacherLink(){
        driver.findElement(TEACHER_LOG_IN).click();
    }

    @Step("Buy Plush Toy & Cards")
    public void plushToyAndCardsLink(){
        driver.findElement(RAYMOND_BUNDLE_LINK).click();
    }
}
