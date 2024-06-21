package ge.tbcacademy.pages.saucedemo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class UserPage {
    public ElementsCollection imagesLoaded = $$x("//div[@class ='inventory_item_img']//img");
    public SelenideElement
            additionall  = $("#react-burger-menu-btn"),
            logOut = $("#logout_sidebar_link");

}
