package steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RickAndMortySteps {
    private final RequestSpecification rickSpecification = new RequestSpecBuilder().setBaseUri("https://rickandmortyapi.com/api").build();

    public List<String> getCharacterEpisodes(int characterId) {
        Response response = given()
                .spec(rickSpecification)
                .log().all()
                .when()
                .get("/character/" + characterId)
                .then()
                .log().all()
                .extract()
                .response();
        List<String> episodes = response.getBody().jsonPath().get("episode");
        return episodes;
    }
}
