package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SbermarketSearchPage {
    public static SelenideElement searchTitle = $x("//h1[@data-qa='search_result_header_title']");
    public static ElementsCollection productCardsName = $$x("//div[contains(@class, 'ProductCard')]/a//h3");
    public static SelenideElement paginationContainer = $x("//div[contains(@class, 'pagination_container')]");
}
