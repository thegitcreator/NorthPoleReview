package automation.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RaymondBundlePage {

    protected final WebDriver driver;

    public RaymondBundlePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static final By MAIN_IMAGE = By.xpath("//img[@id='bigimg']");
    private static final By BUY_BUTTON = By.xpath("//input[@alt='PayPal - The safer, easier way to pay online!']");
    private static final By BUNDLE_COST_IMAGE = By.xpath("//img[@alt='Bundle Cost']");


    public Boolean isImageDisplayed() {
        WebElement result = driver.findElement(MAIN_IMAGE);
        return result.isDisplayed();
    }

    public Boolean isBundleImageDisplayed() {
        WebElement result = driver.findElement(BUNDLE_COST_IMAGE);
        return result.isDisplayed();
    }

    @Step("Click on Buy button")
    public void buyButtonClick(){
        WebElement result = driver.findElement(BUY_BUTTON);
        if(result.isDisplayed()) {
            result.click();
        } else {
            System.out.println("Не найден элемент");
        }
    }
}