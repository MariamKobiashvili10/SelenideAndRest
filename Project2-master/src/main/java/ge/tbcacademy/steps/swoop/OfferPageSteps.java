package ge.tbcacademy.steps.swoop;

import ge.tbcacademy.pages.swoop.OfferPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.switchTo;

public class OfferPageSteps {
    OfferPage offerPage = new OfferPage();
    @Step("Clicking Sharing offer")
    public OfferPageSteps sharingOffer(){
        offerPage.shareOffer.click();
        return this;
    }
    @Step("Switching to facebook window")
    public OfferPageSteps switchingToFacebookWindow(){
        switchTo().window(1);
        int conflict = 1;
        return this;
    }
}
