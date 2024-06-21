package ge.tbcacademy.pages.swoop;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DasvenebaPage {
    public SelenideElement
            categoryFilterDesk = $x("//div[@class = 'category-filter-desk']"),
            minPriceInput = categoryFilterDesk.$x(".//input[@name = 'minprice']"),
            maxPriceInput = categoryFilterDesk.$x(".//input[@name = 'maxprice']"),
            submitButton = categoryFilterDesk.$x(".//div[@class ='submit-button']"),
            locationDropDown = categoryFilterDesk.$x(".//button[@class = 'ms-choice']"),
            location = categoryFilterDesk.$x(".//span[contains(text(),'კრწანისი')]/ancestor::li"),
            complexType = categoryFilterDesk.$x(".//label[contains(text(), 'სასტუმრო')]/input"),
            paymentType = categoryFilterDesk.$x(".//input[@type = 'radio']/parent::*[contains(text(),'ვაუჩერი')]//input"),
            deleteFiltersButton = categoryFilterDesk.$x(".//div[@class = 'delete-search-button']"),
            body = $("#body");
    public ElementsCollection
            pricesOfDasvenebaOffers = $$x("//div[@class = 'special-offer']//div[@class = 'discounted-prices']//p[1]");
}
