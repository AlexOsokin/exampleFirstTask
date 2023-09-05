import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTests {

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        System.out.println("Перед всеми тестами!");
    }

    @BeforeMethod(alwaysRun = true)
    void beforeMethod() {
        System.out.println("Перед каждым тестом!");
    }

    @AfterClass(alwaysRun = true)
    void afterClass() {
        System.out.println("После всех тестов!");
    }

    @Test(description = "Первый тест")
    void FirstTest() {
        System.out.println("Привет, первый тест!");
    }

    @Test(description = "Второй тест тест")
    void SecondTest() {
        System.out.println("Привет, второй тест!");
    }
}
