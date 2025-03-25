package automation.tests;

import automation.org.example.ConfProperties;
import automation.pages.BananaBreadRecipePage;
import automation.pages.CookbookBreadsPage;
import automation.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BreadRecipeTest extends AbstractTest {
    public static String URL = ConfProperties.getProperty("mainpage");

    public static MainPage mainpage;
    public static CookbookBreadsPage cookbookBreadsPage;
    public static BananaBreadRecipePage bananaBreadRecipePage;

    @BeforeMethod
    public void preconditions() {
        setUp();
        mainpage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        shoutDown();
    }

    @Test(description = "Get bread recipe")
    public void getBreadRecipe() {
        driver.get(URL);

        mainpage.breadsLink();

        cookbookBreadsPage = new CookbookBreadsPage(driver);
        Assertions.assertTrue(cookbookBreadsPage.isBreadBlockDisplayed(), "Элемент не найден");
        Assertions.assertTrue(cookbookBreadsPage.isBreadImgDisplayed(), "Элемент не найден");
        Assertions.assertTrue(cookbookBreadsPage.isRecipeSearchDisplayed(), "Элемент не найден");

        cookbookBreadsPage.clickOnRecipeLink();

        bananaBreadRecipePage = new BananaBreadRecipePage(driver);
        Assertions.assertTrue(bananaBreadRecipePage.isRecipeTitleDisplayed(), "Элемент не найден");
        Assertions.assertTrue(bananaBreadRecipePage.isIngredientsDisplayed(), "Элемент не найден");
        Assertions.assertTrue(bananaBreadRecipePage.isDetailsDisplayed(), "Элемент не найден");
        Assertions.assertTrue(bananaBreadRecipePage.isReviewsDisplayed(), "Элемент не найден");
        Assertions.assertTrue(bananaBreadRecipePage.isYumDisplayed(), "Элемент не найден");
        Assertions.assertTrue(bananaBreadRecipePage.isDirectionsDisplayed(), "Элемент не найден");
    }
}
