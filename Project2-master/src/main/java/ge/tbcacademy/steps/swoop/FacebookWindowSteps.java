package ge.tbcacademy.steps.swoop;

import com.codeborne.selenide.WebDriverRunner;
import ge.tbcacademy.data.constants.ConstantsForSwoop;
import io.qameta.allure.Step;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.switchTo;

public class FacebookWindowSteps {
    @Step("Checking window's url is facebook")
    public FacebookWindowSteps validatingFacebookWindow(){
        String currentUrl = WebDriverRunner.url();
        Assert.assertTrue(currentUrl.startsWith(ConstantsForSwoop.FACEBOOK_LOGIN_URL));
        return this;
    }
    @Step("Closing facebook window and switching to swoop")
    public FacebookWindowSteps closingFacebookAndSwitchingToSwoop(){
        closeWindow();
        switchTo().window(0);
        return this;
    }
}
