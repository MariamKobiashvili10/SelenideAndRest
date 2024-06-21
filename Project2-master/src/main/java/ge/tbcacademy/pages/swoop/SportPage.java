package ge.tbcacademy.pages.swoop;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SportPage {
    public SelenideElement
    soldZero = $x("//div[@class = 'special-offer']//p[contains(text(),'გაყიდულია 0')]"),
    voucherDiagramForZeroSells = soldZero.$x("./parent::div/parent::div/child::div[@class = 'voucher-diagram']/div");
}
