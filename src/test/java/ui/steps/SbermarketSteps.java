package ui.steps;

import pages.SbermarketPage;

public class SbermarketSteps {
    public void search(String value) {
        SbermarketPage.searchField.setValue(value);
        SbermarketPage.searchButton.click();
    }
}
