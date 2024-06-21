package ge.tbcacademy.pages.saucedemo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class LoginPage {
    public SelenideElement userName = $("#user-name"),
    usersPassword = $("#password"),
    loginButton = $("#login-button"),
    alertMessage = $(byText("Epic sadface: Sorry, this user has been locked out."));
    public ElementsCollection redXButtons = $$x("//*[name()='svg']");
}
