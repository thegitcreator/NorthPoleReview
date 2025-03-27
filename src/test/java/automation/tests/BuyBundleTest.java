package automation.tests;

import automation.org.example.ConfProperties;
import automation.pages.MainPage;
import automation.pages.PayPalPages.PayPalCheckout;
import automation.pages.RaymondBundlePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BuyBundleTest extends AbstractTest {
    public static String URL = ConfProperties.getProperty("mainpage");

    public static MainPage mainpage;
    public static RaymondBundlePage raymondBundlePage;
    public static PayPalCheckout payPalCheckout;

    @BeforeMethod
    public void preconditions() {
        setUp();
        mainpage = new MainPage(driver);
        raymondBundlePage = new RaymondBundlePage(driver);
        payPalCheckout = new PayPalCheckout(driver);
        raymondBundlePage = new RaymondBundlePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        shoutDown();
    }

    @Test(description = "Cancel buy bundle")
    public void cancelBuyBundleTest() {
        mainpage.plushToyAndCardsLink();

        assertTrue(raymondBundlePage.isBundleImageDisplayed(), "Картинка скидки не найдена");
        assertTrue(raymondBundlePage.isImageDisplayed(), "Основная картинка не найдена");

        raymondBundlePage.buyButtonClick();

        assertTrue(payPalCheckout.isTitleDisplayed(), "Заголовок страницы оплаты не найден");
        assertTrue(payPalCheckout.isContinueButtonDisplayed(), "Кнопка 'Продолжить' не найдена");
        payPalCheckout.cancelBuyLink();

        assertTrue(raymondBundlePage.isBundleImageDisplayed(), "Картинка скидки не найдена");
        assertTrue(raymondBundlePage.isImageDisplayed(), "Основная картинка не найдена");
    }
}