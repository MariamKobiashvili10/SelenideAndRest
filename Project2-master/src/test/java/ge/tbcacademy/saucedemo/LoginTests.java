package ge.tbcacademy.saucedemo;

import com.codeborne.selenide.logevents.SelenideLogger;
import ge.tbcacademy.listeners.CustomTestListener;
import ge.tbcacademy.util.ModdedAllureSelenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import ge.tbcacademy.data.constants.ConstantsForSauceDemo;
import ge.tbcacademy.data.DatabaseSteps;
import ge.tbcacademy.pages.saucedemo.LoginPage;
import ge.tbcacademy.pages.saucedemo.UserPage;
import ge.tbcacademy.steps.saucedemo.LoginPageSteps;
import ge.tbcacademy.steps.saucedemo.UserPageSteps;
import org.testng.annotations.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Epic("SauceDemo testing")
@Test(groups = "SauceDemoLogin")
@Listeners(CustomTestListener.class)
public class LoginTests {
    LoginPage loginPage;
    LoginPageSteps loginPageSteps;
    UserPageSteps userPageSteps;
    UserPage userPage;
    DatabaseSteps databaseSteps;

    @BeforeClass
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new ModdedAllureSelenide());
        loginPage = new LoginPage();
        loginPageSteps = new LoginPageSteps();
        userPage = new UserPage();
        userPageSteps = new UserPageSteps();
        databaseSteps = new DatabaseSteps();
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void openBrowser() {
        open(ConstantsForSauceDemo.SAUCEDEMO_URL);
        getWebDriver().manage().window().maximize();
    }

    @Feature("Login Functionality")
    @Description("Testing saucedemo standard_User login and validating images displayed")
    @Story("As a user i want to login with a standarduser account")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1, description = "Testing with standard_user account")
    public void successfulLoginTest() {
        try (ResultSet resultSet = databaseSteps.selectUserByUsername(ConstantsForSauceDemo.STANDARD_USER)) {
            while (resultSet.next()) {
                loginPageSteps
                        .inputLogin(loginPage.userName, resultSet.getString("username"))
                        .inputLogin(loginPage.usersPassword, resultSet.getString("password"))
                        .clickOnLoginButton();
            }
            userPageSteps.validatingImagesForStandardUser();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Feature("Login Functionality")
    @Description("Testing locked_out_user login and validating its alert message visibility")
    @Story("As a user, I want t login with a locked-out account")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, description = "Testing with locked_out_user")
    public void bannedUserLoginTest() {
        try (ResultSet resultSet = databaseSteps.selectUserByUsername(ConstantsForSauceDemo.LOCKED_OUT_USER)) {
            while (resultSet.next()) {
                loginPageSteps
                        .inputLogin(loginPage.userName, resultSet.getString("username"))
                        .inputLogin(loginPage.usersPassword, resultSet.getString("password"))
                        .clickOnLoginButton();
                loginPageSteps.alertMessageValidation()
                        .ValidateRedButtonsVisibility();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Feature("Login Functionality")
    @Description("Testing problem_user login and validating that loaded images shouldn't be the same")
    @Story("Upon successful login, verifying that the loaded images are different from each other")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 3, description = "Testing with problem_user")
    public void problematicLoginTest() {
        try (ResultSet resultSet = databaseSteps.selectUserByUsername(ConstantsForSauceDemo.PROBLEM_USER)) {
            while (resultSet.next()) {
                loginPageSteps
                        .inputLogin(loginPage.userName, resultSet.getString("username"))
                        .inputLogin(loginPage.usersPassword, resultSet.getString("password"))
                        .clickOnLoginButton();
                userPageSteps.validatingImagesForProblemUser();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Feature("Logout Functionality")
    @Description(" Testing the logout functionality for a standard user account.")
    @Story("After logging out, ensure that login inputs are empty")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 4, description = "other tests on standard_user")
    public void logOutTest() {
        try (ResultSet resultSet = databaseSteps.selectUserByUsername(ConstantsForSauceDemo.STANDARD_USER)) {
            while (resultSet.next()) {
                loginPageSteps
                        .inputLogin(loginPage.userName, resultSet.getString("username"))
                        .inputLogin(loginPage.usersPassword, resultSet.getString("password"))
                        .clickOnLoginButton();
                userPageSteps.logOut();
                loginPageSteps.validateLogInInputsAreEmpty();
                System.out.println("Also made for conflict ++");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }

}
