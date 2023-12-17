package pl.coderslab.shopping;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.*;

import java.io.File;
import java.lang.module.FindException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ShoppingSteps {
    private WebDriver driver;
    private ProductPage productPage;
    private FinalizationPage finalizationPage;

    @Given("I am logged in with email {word} and password {word}")
    public void iAmLoggedIn(String email, String password) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.of(3, ChronoUnit.SECONDS));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email, password);
    }

    @When("I search for {string}")
    public void iSearchFor(String productName) {
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.searchFor(productName);
    }

    @And("I click on first card")
    public void iClickOnCard() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.clickOnFirstProduct();
    }

    @And("I choose size {string}")
    public void iChooseSize(String size) {
        productPage = new ProductPage(driver);
        productPage.chooseSize(size);
    }

    @And("I change quantity to {int}")
    public void iChangeQuantityTo(int quantity) {
        productPage.changeQuantity(quantity);

    }

    @And("I click Add to card")
    public void iClickAddToCard() {
        productPage.clickAddToCard();
    }

    @And("I click proceed to checkout on alert dialog")
    public void iClickProceedToCheckoutOnAlertDialog() {
        ProceedToCheckoutAlertPage proceedToCheckoutAlertPage = new ProceedToCheckoutAlertPage(driver);
        proceedToCheckoutAlertPage.clickOnProceedButton();
    }

    @And("I click proceed to checkout on shopping card page")
    public void iClickProceedToCheckoutOnShoppingCardPage() {
        ProceedToCheckoutPage proceedToCheckoutPage = new ProceedToCheckoutPage(driver);
        proceedToCheckoutPage.clickOnProceedButton();
    }

    @And("I confirm address by clicking continue button")
    public void iConfirmAddressByClickingContinueButton() {
        finalizationPage = new FinalizationPage(driver);
        finalizationPage.confirmAddress();

    }

    @And("I confirm Self pick up shipping method by clicking continue button")
    public void iConfirmSelfPickUpShippingMethodByClickingContinueButton() {
        finalizationPage.confirmShippingMethod();
    }

    @And("I choose pay by Check option")
    public void iChoosePayByCheckOption() {
        finalizationPage.choosePayByCheckOption();
    }

    @And("I agree with terms of service")
    public void iAgreeWithTermsOfService() {
        finalizationPage.agreeWithTerms();
    }

    @And("I place order")
    public void iPlaceOrder() {
        finalizationPage.placeOrder();
    }

    @Then("Screenshot with order confirmation is created")
    public void screenshotWithOrderConfirmationIsCreated() {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    }

    @And("I Close browser")
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}

