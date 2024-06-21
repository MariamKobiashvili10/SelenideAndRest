package ge.tbcacademy.pages.swoop;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AuthorizationPage {
    public SelenideElement tNetLogin = $x("//form[@id = 'LoginForm']");
}
