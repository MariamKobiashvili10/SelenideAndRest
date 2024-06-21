package ge.tbcacademy.steps.saucedemo;

import com.codeborne.selenide.SelenideElement;
import ge.tbcacademy.pages.saucedemo.LoginPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import static com.codeborne.selenide.Condition.visible;

public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();

    @Step("Inputting {1} in input {0}")
    public LoginPageSteps inputLogin(SelenideElement element, String credentials){
        element.sendKeys(credentials);
        return this;

    }
    @Step("Clicking On login Button")
    public LoginPageSteps clickOnLoginButton(){
        loginPage.loginButton.click();
        return this;
    }
    @Step("Validating that alert message is visible")
    public LoginPageSteps alertMessageValidation(){
        loginPage.alertMessage.shouldBe(visible);
        return this;
    }
    @Step("Validating Button visibility")
    public LoginPageSteps ValidateRedButtonsVisibility(){
        for(SelenideElement redX : loginPage.redXButtons){
            redX.shouldBe(visible);
        }
        return this;
    }
    @Step("Validating login inputs are empty")
    public LoginPageSteps validateLogInInputsAreEmpty(){
        Assert.assertTrue(loginPage.userName.getAttribute("value").isEmpty() &&
                loginPage.usersPassword.getAttribute("value").isEmpty());
        return this;
    }
}
