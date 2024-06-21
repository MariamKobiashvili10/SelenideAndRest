package ge.tbcacademy.steps.swoop;

import com.codeborne.selenide.SelenideElement;
import ge.tbcacademy.pages.swoop.BasePage;
import io.qameta.allure.Step;

public class BasePageSteps {
    BasePage basePage = new BasePage();
    @Step("hovering and Clicking on element {0}")
    public BasePageSteps clickOnElement(SelenideElement element){
        element.hover().click();
        return this;
    }
    @Step("Hovering On categories element")
    public BasePageSteps hoverOnCategoriesElement(){
        basePage.optionFromCategories.hover();
        return this;
    }

}
