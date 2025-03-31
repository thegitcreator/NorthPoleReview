package automation.tests;

import automation.org.example.ConfProperties;
import automation.pages.BananaBreadRecipePage;
import automation.pages.CookbookBreadsPage;
import automation.pages.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BreadRecipeTest extends AbstractTest {
    public static String URL = ConfProperties.getProperty("mainpage");

    public static MainPage mainpage;
    public static CookbookBreadsPage cookbookBreadsPage;
    public static BananaBreadRecipePage bananaBreadRecipePage;

    @BeforeMethod
    public void preconditions() {
        setUp();
        mainpage = new MainPage(driver);
        cookbookBreadsPage = new CookbookBreadsPage(driver);
        bananaBreadRecipePage = new BananaBreadRecipePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        shoutDown();
    }

    @Test(description = "Get bread recipe")
    public void getBreadRecipe() {
        mainpage.breadsLink();

        assertTrue(cookbookBreadsPage.isBreadBlockDisplayed(), "Блок с рецептами не найден");
        assertTrue(cookbookBreadsPage.isBreadImgDisplayed(), "Основная картинка раздела рецептов хлеба не найдена");
        assertTrue(cookbookBreadsPage.isRecipeSearchDisplayed(), "Форма поиска рецепта не найдена");

        cookbookBreadsPage.clickOnRecipeLink();

        assertTrue(bananaBreadRecipePage.isRecipeTitleDisplayed(), "Заголовок рецепта не найден");
        assertTrue(bananaBreadRecipePage.isIngredientsDisplayed(), "Ингридиенты рецепта не найдена");
        assertTrue(bananaBreadRecipePage.isDetailsDisplayed(), "Детали рецепта не найдены");
        assertTrue(bananaBreadRecipePage.isReviewsDisplayed(), "Отзывы не найдены");
        assertTrue(bananaBreadRecipePage.isYumDisplayed(), "Блок Yum не найден");
        assertTrue(bananaBreadRecipePage.isDirectionsDisplayed(), "Директивы не найдены");
    }
}