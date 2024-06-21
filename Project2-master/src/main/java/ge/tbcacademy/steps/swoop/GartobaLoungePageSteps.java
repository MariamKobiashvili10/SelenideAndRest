package ge.tbcacademy.steps.swoop;

import com.codeborne.selenide.SelenideElement;
import ge.tbcacademy.pages.swoop.GartobaLoungePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;

public class GartobaLoungePageSteps {
    GartobaLoungePage gartobaLoungePage = new GartobaLoungePage();
    @Step("Clicking on element {0} ")
    public GartobaLoungePageSteps clickOnElement(SelenideElement element){
       element.click();
        return this;
    }
    @Step("Validating that vouchers are not sold out")
    public GartobaLoungePageSteps validateVouchersDiagram(){
        gartobaLoungePage.voucher.shouldNotHave(attribute("data-width", "100"));
        return this;
    }
}
