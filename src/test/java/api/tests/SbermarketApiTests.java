package api.tests;

import api.steps.SbermarketApiSteps;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SbermarketApiTests {
    private SbermarketApiSteps sbermarketApiSteps;

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        sbermarketApiSteps = new SbermarketApiSteps();
    }

    @Test(description = "Поиск товаров по ритейлеру 'Ашан' - предложения поиска")
    @TmsLink("258558")
    void successSearchAuchanSuggestsTest() {
        String firstValue = "яблоко";
        String secondValue = "сок";
        Response response = sbermarketApiSteps.getSuggests(firstValue + " " + secondValue, 70);

        SoftAssert softAssert = new SoftAssert();

        response.body().jsonPath().getList("suggests[0].text.completion.text").forEach(
                v -> softAssert.assertTrue(v.toString().startsWith(firstValue + " " + secondValue))
        );

        String name = response.body().jsonPath().get("suggests[1].product.completion[0].name");
        softAssert.assertTrue(name.toLowerCase().contains(firstValue));
        softAssert.assertTrue(name.toLowerCase().contains(secondValue));

        softAssert.assertAll();
    }
}
