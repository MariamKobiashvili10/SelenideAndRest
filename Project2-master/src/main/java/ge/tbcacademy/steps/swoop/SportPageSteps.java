package ge.tbcacademy.steps.swoop;

import ge.tbcacademy.pages.swoop.SportPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;

public class SportPageSteps {
    SportPage sportPage = new SportPage();

    @Step("Validating that offers with 0 sells have all vouchers")
    public SportPageSteps validateProgressBar(){
        sportPage.voucherDiagramForZeroSells.shouldHave(attribute("data-width", "0"));
        return this;

    }
}
