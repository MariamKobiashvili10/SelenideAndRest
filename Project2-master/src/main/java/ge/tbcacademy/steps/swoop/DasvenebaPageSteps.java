package ge.tbcacademy.steps.swoop;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import ge.tbcacademy.data.constants.ConstantsForSwoop;
import ge.tbcacademy.pages.swoop.DasvenebaPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.assertFalse;


public class DasvenebaPageSteps {

    DasvenebaPage dasvenebaPage = new DasvenebaPage();

    @Step("Input Price {1} in element {0}")
    public DasvenebaPageSteps inputtingPriceRange(SelenideElement element, String price) {
        element.hover().sendKeys(price);
        return this;
    }
    @Step("attribute should be provided text")
    public DasvenebaPageSteps settingConditionToWait(){
        dasvenebaPage.body.shouldHave(attribute("style", "overflow: unset;"));
        return this;
    }

    @Step("Clicking On Search Button")
    public DasvenebaPageSteps clickOnSearch() {
        dasvenebaPage.submitButton.hover().click();
        return this;
    }

    @Step("Validating If Price Range from {0} to {1} works properly")
    public DasvenebaPageSteps validatePriceRange(double minPrice, double maxPrice) {
        List<Double> pricesList = new ArrayList<>();
        for (SelenideElement price : dasvenebaPage.pricesOfDasvenebaOffers) {
            double PriceInInteger = Double.parseDouble(price.getText().replaceAll("[^0-9.]", ""));
            pricesList.add(PriceInInteger);
        }
            double maximumPrice =  Collections.max(pricesList);
            double minimumPrice = Collections.min(pricesList);

        Assert.assertTrue(maximumPrice <= maxPrice && minimumPrice >= minPrice);
        return this;

    }
    @Step("Setting location")
    public DasvenebaPageSteps setLocation(){
        dasvenebaPage.locationDropDown.click();
        dasvenebaPage.location.click();
        dasvenebaPage.locationDropDown.click();
        return this;

    }
    @Step("Setting type of housing")
    public DasvenebaPageSteps setTypeOfHousing(){
        dasvenebaPage.complexType.click();
        return this;

    }

    @Step("Setting payment type")
    public DasvenebaPageSteps setPaymentType(){
        dasvenebaPage.paymentType.click();
        return this;
    }

    @Step("Deleting filters")
    public DasvenebaPageSteps deleteFilters(){
        dasvenebaPage.deleteFiltersButton.click();
        return this;
    }

    @Step("Validating if deletion works properly")
    public DasvenebaPageSteps validateDeleteButton(){
        dasvenebaPage.location.shouldNotHave(attribute("class", "selected"));
        dasvenebaPage.complexType.shouldNotBe(checked);
        dasvenebaPage.paymentType.shouldNotBe(selected);
        String currentURL = WebDriverRunner.url();
        assertFalse(currentURL.contains(ConstantsForSwoop.MINIMAL_PRICE) && currentURL.contains(ConstantsForSwoop.MAXIMUM_PRICE));
        return this;
    }
}
