package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import steps.RickAndMortySteps;

import java.util.List;

public class RickAndMortyTests {
    private RickAndMortySteps rickAndMortySteps;

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        rickAndMortySteps = new RickAndMortySteps();
    }

    @Test(description = "Успешное получение эпизодов для Морти")
    void successGetMortyEpisodesTest() {
        List<String> episodes = rickAndMortySteps.getCharacterEpisodes(2);
        Assert.assertEquals(episodes.size(), 51, "Количество эпизодов не совпадает");
    }
}
