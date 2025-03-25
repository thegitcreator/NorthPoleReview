package automation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BananaBreadRecipePage {

    private static final By RECIPE_TITLE = By.xpath("//h1[contains(text(), 'Bread')]");
    private static final By YUM_SHARE = By.xpath("//div[@id='yumshare']");
    private static final By RECIPE_DETAILS = By.xpath("//h2[text()='Recipe Details']");
    private static final By INGREDIENTS = By.xpath("//h2[text()='Ingredients']");
    private static final By DIRECTIONS = By.xpath("//h2[text()='Directions']");
    private static final By REVIEWS = By.xpath("//h2[text()='Reviews']");

    public BananaBreadRecipePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private final WebDriver driver;

    public Boolean isRecipeTitleDisplayed() {
        WebElement result = driver.findElement(RECIPE_TITLE);
        return result.isDisplayed();
    }

    public Boolean isYumDisplayed() {
        WebElement result = driver.findElement(YUM_SHARE);
        return result.isDisplayed();
    }

    public Boolean isDetailsDisplayed() {
        WebElement result = driver.findElement(RECIPE_DETAILS);
        return result.isDisplayed();
    }

    public Boolean isIngredientsDisplayed() {
        WebElement result = driver.findElement(INGREDIENTS);
        return result.isDisplayed();
    }

    public Boolean isDirectionsDisplayed() {
        WebElement result = driver.findElement(DIRECTIONS);
        return result.isDisplayed();
    }

    public Boolean isReviewsDisplayed() {
        WebElement result = driver.findElement(REVIEWS);
        return result.isDisplayed();
    }
}
