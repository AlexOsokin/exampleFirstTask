package ui.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.steps.SbermarketUiSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class SbermarketUiTests {
    private SbermarketUiSteps sbermarketSteps;

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        sbermarketSteps = new SbermarketUiSteps();
    }

    @BeforeMethod(description = "Открывает браузер на странице sbermarket.ru")
    public void beforeMethod() {
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver120");
        open("https://sbermarket.ru/");
    }

    @AfterMethod(description = "Закрываем браузер")
    public void afterMethod() {
        closeWebDriver();
    }

    @Test(description = "Поиск товаров по ритейлеру 'Metro'")
    @TmsLink("258538")
    public void searchMetroTest() {
        String productNameExp = "яблоки";
        sbermarketSteps.searchMetro(productNameExp);
        sbermarketSteps.checkSearch(productNameExp);
    }
}
