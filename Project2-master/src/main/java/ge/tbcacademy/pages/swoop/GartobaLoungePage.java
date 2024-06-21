package ge.tbcacademy.pages.swoop;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GartobaLoungePage {
    public SelenideElement addToFavorites = $x("//div[@class ='deal-basket-wishlist']"),
    firstOffer = $x("//div[@class = 'special-offer']"),
    voucher = $x("//div[@class = 'voucher-diagram']//div");
}
