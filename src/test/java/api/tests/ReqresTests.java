package api.tests;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import api.steps.ReqresSteps;

@Epic("Api тесты")
@Feature("Reqres тесты")
@Story("POST client")
public class ReqresTests {
    private ReqresSteps reqresSteps;

    @BeforeClass(description = "Добавляем фильтр Allure для RestAssured", alwaysRun = true)
    void addFilters() {
        RestAssured.filters(new AllureRestAssured());
    }

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        reqresSteps = new ReqresSteps();
    }

    @Issue("SPC-2122")
    @TmsLink("225879")
    @Test(description = "Создание клиента")
    void successCreateClientTest() {
        String clientRequestBody = reqresSteps.getReqresRequestBody("client.json");
        String clientResponseBody = reqresSteps.postClient(clientRequestBody);

        String expectedClientName = new JSONObject(clientRequestBody).get("name").toString();

        String actualClientName = new JSONObject(clientResponseBody).get("name").toString();
        String clientId = new JSONObject(clientResponseBody).get("id").toString();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualClientName, expectedClientName, "Имя сохранилось неверно");
        softAssert.assertNotNull(clientId, "id клиента равен null");
        softAssert.assertAll();
    }
}