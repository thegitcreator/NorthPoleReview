package automation.tests;

import automation.org.example.ConfProperties;
import automation.pages.MainPage;
import automation.pages.PayPalPages.PayPalCheckout;
import automation.pages.RaymondBundlePage;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BuyBundleTest extends AbstractTest {
    public static String URL = ConfProperties.getProperty("mainpage");

    public static MainPage mainpage;
    public static RaymondBundlePage raymondBundlePage;
    public static PayPalCheckout payPalCheckout;

    @BeforeMethod
    public void preconditions() {
        setUp();
        mainpage = new MainPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        shoutDown();
    }

    @Test(description = "Cancel buy bundle")
    public void cancelBuyBundleTest() {
        driver.get(URL);

        mainpage.plushToyAndCardsLink();

        raymondBundlePage = new RaymondBundlePage(driver);
        Assertions.assertTrue(raymondBundlePage.isBundleImageDisplayed(), "Элемент не найден");
        Assertions.assertTrue(raymondBundlePage.isImageDisplayed(), "Элемент не найден");

        raymondBundlePage.buyButtonClick();

        payPalCheckout = new PayPalCheckout(driver);
        Assertions.assertTrue(payPalCheckout.isTitleDisplayed(), "Элемент не найден");
        Assertions.assertTrue(payPalCheckout.isContinueButtonDisplayed(), "Элемент не найден");
        payPalCheckout.cancelBuyLink();

        raymondBundlePage = new RaymondBundlePage(driver);
        Assertions.assertTrue(raymondBundlePage.isBundleImageDisplayed(), "Элемент не найден");
        Assertions.assertTrue(raymondBundlePage.isImageDisplayed(), "Элемент не найден");
    }

}
