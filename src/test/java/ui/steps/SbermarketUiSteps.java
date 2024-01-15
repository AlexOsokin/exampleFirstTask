package ui.steps;

import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import pages.SbermarketMainPage;
import pages.SbermarketSearchPage;

import static com.codeborne.selenide.Condition.visible;

public class SbermarketUiSteps {
    @Step("Поиск по значению {value} для ритейлера 'Metro'")
    public void searchMetro(String value) {
        SbermarketMainPage.metroButton.click();
        SbermarketMainPage.searchField.setValue(value);
        SbermarketMainPage.searchBlock.shouldBe(visible);
        SbermarketMainPage.searchButton.click();
    }

    @Step("Проверка результатов поиска по значению {value}")
    public void checkSearch(String value) {
        SbermarketSearchPage.paginationContainer.shouldBe(visible);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(SbermarketSearchPage.searchTitle.getText(), "Результаты поиска по запросу: " + value);
        softAssert.assertEquals(SbermarketSearchPage.productCardsName.size(), 24);
        softAssert.assertTrue(SbermarketSearchPage.productCardsName.get(0).getText().toLowerCase().contains(value));
        softAssert.assertTrue(SbermarketSearchPage.productCardsName.get(1).getText().toLowerCase().contains(value));
        softAssert.assertAll();
    }
}
