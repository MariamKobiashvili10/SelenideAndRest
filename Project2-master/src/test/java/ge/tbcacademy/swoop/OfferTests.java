package ge.tbcacademy.swoop;

import com.codeborne.selenide.logevents.SelenideLogger;
import ge.tbcacademy.data.DataProvider;
import ge.tbcacademy.listeners.CustomTestListener;
import ge.tbcacademy.pages.swoop.BasePage;
import ge.tbcacademy.pages.swoop.DasvenebaPage;
import ge.tbcacademy.pages.swoop.GartobaLoungePage;
import ge.tbcacademy.steps.swoop.*;
import ge.tbcacademy.util.ModdedAllureSelenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import ge.tbcacademy.data.constants.ConstantsForSwoop;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Epic("Swoop Tests")
@Test(groups = "SwoopRegression")
@Listeners(CustomTestListener.class)
public class OfferTests {
    BasePage basePage;
    DasvenebaPage dasvenebaPage;
    BasePageSteps basePageSteps;
    DasvenebaPageSteps dasvenebaPageSteps;
    GartobaLoungePage gartobaLoungePage;
    GartobaLoungePageSteps gartobaLoungePageSteps;
    AuthorizationPageSteps authorizationPageSteps;
    OfferPageSteps offerPageSteps;
    SportPageSteps sportPageSteps;
    FacebookWindowSteps facebookWindowSteps;

    @BeforeClass
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new ModdedAllureSelenide());
        WebDriverManager.chromedriver().setup();
        basePage = new BasePage();
        dasvenebaPage = new DasvenebaPage();
        basePageSteps = new BasePageSteps();
        dasvenebaPageSteps = new DasvenebaPageSteps();
        gartobaLoungePage = new GartobaLoungePage();
        gartobaLoungePageSteps = new GartobaLoungePageSteps();
        authorizationPageSteps = new AuthorizationPageSteps();
        offerPageSteps = new OfferPageSteps();
        sportPageSteps = new SportPageSteps();
        facebookWindowSteps = new FacebookWindowSteps();

    }
    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        open(ConstantsForSwoop.SWOOP_URL);
        getWebDriver().manage().window().maximize();
        basePageSteps.clickOnElement(basePage.cookieButton);

    }

    @Feature("Price Range")
    @Description(" Test the functionality of setting minimum and maximum price ranges for offers on the Dasveneba page")
    @Story("Validate price ranges for offers on Dasveneba page")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1, description = "Testing Price Range feature", dataProvider = "pricesDataProvider", dataProviderClass = DataProvider.class)
    public void rangeTest(String minPrice, String maxPrice){
        basePageSteps.clickOnElement(basePage.dasvenebaSection);
        dasvenebaPageSteps
                .inputtingPriceRange(dasvenebaPage.minPriceInput, minPrice)
                .inputtingPriceRange(dasvenebaPage.maxPriceInput, maxPrice)
                .clickOnSearch()
                .settingConditionToWait();
        dasvenebaPageSteps.validatePriceRange(Double.parseDouble(minPrice), Double.parseDouble(maxPrice));
        //double-ში იმიტომ გადამყავს და იმიტომ ვამოწმებ ასე, რომ იყო შემთხვევა, არამთელი რიცხვი იყო სვუპზე ფასი
        //და სიზუსტისთვის.

    }

    @Feature("Favorite Offer")
    @Description("Test the functionality of adding an offer to favorites and verifying the appearance of the login page")
    @Story("Verify that the login page appears after adding the offer to favorites")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "adding offer to favorites", priority = 2)
    public void favouriteOfferTest(){
        basePageSteps
                .clickOnElement(basePage.categories)
                .hoverOnCategoriesElement()
                .clickOnElement(basePage.lounge);
        gartobaLoungePageSteps.clickOnElement(gartobaLoungePage.addToFavorites);
        authorizationPageSteps
                .validatingLogInPage()
                .goBackToGartobaLoungePage();
        gartobaLoungePageSteps.validateVouchersDiagram();


    }
    @Feature("Offer Sharing")
    @Description("Test the functionality of sharing an offer and validating the appearance of the Facebook login page")
    @Story("Validate Facebook login prompt after sharing offer")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(description = "Sharing offer", priority = 3)
    public void shareOfferTest(){
        basePageSteps
                .clickOnElement(basePage.categories)
                .hoverOnCategoriesElement()
                .clickOnElement(basePage.lounge);
        gartobaLoungePageSteps.clickOnElement(gartobaLoungePage.firstOffer);
        offerPageSteps
                .sharingOffer()
                .switchingToFacebookWindow();
        facebookWindowSteps
                .validatingFacebookWindow()
                .closingFacebookAndSwitchingToSwoop();


    }
    @Feature("Progress Bar")
    @Description("Test the progress bar for offers that haven't been sold yet, ensuring it's empty")
    @Story("Check empty progress bar for unsold offers in sport category")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "Validating progress bar", priority = 4)
    public void noOffersSoldTest(){
        basePageSteps.clickOnElement(basePage.sport);
        sportPageSteps.validateProgressBar();

    }

    @Feature("Filter Deletion")
    @Description("Test the functionality of deleting filters by setting location and other details and ensuring the delete button works properly")
    @Story("Test filter deletion functionality")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Testing delete filter", priority = 5)
    public void clearFilterTest(){
        basePageSteps.clickOnElement(basePage.dasvenebaSection);
        dasvenebaPageSteps
                .setLocation()
                .setTypeOfHousing()
                .setPaymentType()
                .inputtingPriceRange(dasvenebaPage.minPriceInput, ConstantsForSwoop.INPUT_MINIMAL_PRICE)
                .inputtingPriceRange(dasvenebaPage.maxPriceInput, ConstantsForSwoop.INPUT_MAXIMUM_PRICE)
                .deleteFilters()
                .validateDeleteButton();
        System.out.println("Added for conflict +++++++");
    }
    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }

}

