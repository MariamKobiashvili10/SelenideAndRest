package ge.tbcacademy.util;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.selenide.AllureSelenide;

public class ModdedAllureSelenide extends AllureSelenide {
    private boolean savingScreenshot;
    @Override
    public ModdedAllureSelenide screenshots(boolean savingScreenshot){
        if(WebDriverRunner.hasWebDriverStarted()){
            this.savingScreenshot = savingScreenshot;
        }
        return this;
    }
}
