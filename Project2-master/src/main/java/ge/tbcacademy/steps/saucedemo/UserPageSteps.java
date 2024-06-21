package ge.tbcacademy.steps.saucedemo;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ge.tbcacademy.pages.saucedemo.UserPage;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Condition.visible;

public class UserPageSteps {
    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();

    @Step("Validating standard_user account images are loaded correctly")
    public UserPageSteps validatingImagesForStandardUser() {
        for (SelenideElement element : userPage.imagesLoaded) {
            String srcValue = element.getAttribute("src");
            softAssert.assertFalse(srcValue.isEmpty());
            element.shouldBe(visible);
        }
        softAssert.assertAll();
        return this;

        //აქ რეალურად არ აფეილებს, თუმცა ვინაიდან ციკლში მაქვსს გაშვებული და რამდენჯერმე
        //მოუწევს ვალიდაციის გაკეთება ასერტით, გავუწერე სოფტი
    }

    @Step("Validating image source's for problem_user account")
    public UserPageSteps validatingImagesForProblemUser() {
        List<String> imageSources = new ArrayList<>();
        for (SelenideElement image : userPage.imagesLoaded) {
            String imageSource = image.getAttribute("src");
            imageSources.add(imageSource);
        }
        //სეტში გადაგვყავს რათა გავიგოთ image source-ში დუბლიკატები ხომ არ არის
        Set<String> uniqueImageSources = new HashSet<>(imageSources);
        Assert.assertEquals(uniqueImageSources.size(), imageSources.size(),
                "loaded pictures in problem_user have duplicate src");
        return this;
    }

    @Step("Logging out from Standard_user account")
    public UserPageSteps logOut(){
        Selenide.executeJavaScript("arguments[0].click();",userPage.additionall);
        Selenide.executeJavaScript("arguments[0].click();",userPage.logOut);
        return this;
    }
}
