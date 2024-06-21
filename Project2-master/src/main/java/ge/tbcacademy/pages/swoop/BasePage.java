package ge.tbcacademy.pages.swoop;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    public SelenideElement
            cookieButton = $("div.acceptCookie"),
            dasvenebaSection = $x("//a[div[contains(@class, 'MenuIcon')] and normalize-space() = 'დასვენება']"),
            categories = $x("//p[@class ='categoriesTitle']"),
            optionFromCategories = $x("//a[@class ='mainCategories' and contains(text(), 'გართობა')]"),
            lounge = $x("//a[contains(text(),'ლაუნჯი')]"),
            sport = $x("//a[div[contains(@class, 'MenuIcon')] and normalize-space() = 'სპორტი']");

}
