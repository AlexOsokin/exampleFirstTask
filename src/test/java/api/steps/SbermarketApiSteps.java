package api.steps;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class SbermarketApiSteps {
    private static RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri("https://sbermarket.ru").setContentType("application/json").build();

    @Step("Получаем предложения поиска {searchValue} для ритейлера {retailerId}")
    public Response getSuggests(String searchValue, int retailerId) {

        Map<String, Object> queryParams = new HashMap<String, Object>() {{
            put("q", searchValue);
            put("sid", retailerId);
            put("tenant_id", "sbermarket");
        }};

        Response response = given()
                .spec(requestSpecification)
                .when()
                .log().all()
                .queryParams(queryParams)
                .get("/api/gw/web/v1/suggests")
                .then()
                .log().all()
                .extract()
                .response();
        Assert.assertEquals("Ошибка статус-кода", 200, response.getStatusCode());
        return response;
    }
}
