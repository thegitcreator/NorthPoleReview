package automation.pages.PayPalPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PayPalCheckout {
    private static final By TITLE = By.xpath("//h1[@class='alpha ng-binding']");
    private static final By CONTINUE_BUTTON = By.xpath("//input[@class='continue-btn btn']");
    private static final By CANCEL_LINK = By.xpath("//a[@id='cancelLink']");

    protected final WebDriver driver;

    public PayPalCheckout(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Boolean isTitleDisplayed(){
        WebElement result = driver.findElement(TITLE);
        return result.isDisplayed();
    }

    public Boolean isContinueButtonDisplayed(){
        WebElement result = driver.findElement(CONTINUE_BUTTON);
        return result.isDisplayed();
    }

    @Step("Cancel buy")
    public void cancelBuyLink(){
        WebElement result = driver.findElement(CANCEL_LINK);
        if(result.isDisplayed()) {
            result.click();
        } else {
            System.out.println("Не найден элемент");
        }
    }


}
