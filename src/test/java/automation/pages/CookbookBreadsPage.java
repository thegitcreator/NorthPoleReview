package automation.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CookbookBreadsPage {

    private static final By BREADS_IMG = By.xpath("//img[@src='/images/kitchen/banner_cat60.gif']");
    private static final By BREADS_BLOCK = By.id("CBcontain2");
    private static final By RECIPE_SEARCH = By.xpath("//form[@action='Recipe-Search.asp']");

    public CookbookBreadsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private final WebDriver driver;

    public Boolean isBreadImgDisplayed() {
        WebElement result = driver.findElement(BREADS_IMG);
        return result.isDisplayed();
    }

    public Boolean isBreadBlockDisplayed() {
        WebElement result = driver.findElement(BREADS_BLOCK);
        return result.isDisplayed();
    }

    public Boolean isRecipeSearchDisplayed() {
        WebElement result = driver.findElement(RECIPE_SEARCH);
        return result.isDisplayed();
    }

    @Step("Select recipe")
    public void clickOnRecipeLink(){
        driver.findElement(By.xpath("//a[contains(text(), 'Banana Bread')]")).click();
    }
}
