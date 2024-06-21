package ge.tbcacademy.steps.swoop;

import com.codeborne.selenide.Selenide;
import ge.tbcacademy.pages.swoop.AuthorizationPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;

public class AuthorizationPageSteps {
    AuthorizationPage authorizationPage = new AuthorizationPage();

    @Step("checking that login page appeared")
    public AuthorizationPageSteps validatingLogInPage(){
        authorizationPage.tNetLogin.should(appear);
        return this;
    }
    @Step("Going back to page")
    public AuthorizationPageSteps goBackToGartobaLoungePage(){
        Selenide.back();
        return this;
    }
}
