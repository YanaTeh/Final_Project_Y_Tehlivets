package pl.coderslab;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddAddressSteps {
    private WebDriver driver;
    private NewAddressPage newAddressPage;
    private YourAddressesPage yourAddressesPage;

    @Given("I am logged in to Coderslab testlab with email {word} and password {word}")
    public void iamLoggedTestLabPage(String email, String password){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.of(3, ChronoUnit.SECONDS));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(email, password);
    }

    @When("I click add first address tile")
    public void iClickAddFirstAddressTile() {
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.clickAddFirstAddressTile();

    }

    @And("I fill new address form with {word} {word} {word} {word} {word}")
    public void iFillNewAddressFormWithFirstnameLastnameAddressCityPostcodeAndCountry(String firstname, String lastname, String address, String city, String postcode) {
        newAddressPage = new NewAddressPage(driver);
        newAddressPage.fillData(firstname, lastname, address, city, postcode, "United Kingdom");
    }

    @And("I save new address form")
    public void iSaveNewAddressForm(){
        newAddressPage.saveData();
    }

    @Then("I can see new address")
    public void addressSuccessfullyAdded() {
        yourAddressesPage = new YourAddressesPage(driver);
        assertTrue(yourAddressesPage.addressIsVisible(),"Address successfully added!");

    }

    @And("I verify created address {word}, {word}, {word}, {word}, {word}")
    public void iVerifyCreatedAddresses(String firstname, String lastname, String address, String city, String postcode){
        String addressAsText = yourAddressesPage.getLastAddressAsText();
        assertTrue(addressAsText.contains(firstname + " " + lastname + "\n" + address + "\n" + city + "\n" + postcode + "\n" + "United Kingdom"));

    }

    @And("I delete last address")
    public void iDeleteLastAddress(){
        Integer addressesSizeBeforeDelete = yourAddressesPage.getAddressesSize();
        yourAddressesPage.deleteLastAddress();
        Integer addressesSizeAfterDelete = yourAddressesPage.getAddressesSize();
        assertEquals(addressesSizeBeforeDelete - 1, (int) addressesSizeAfterDelete);

    }

    @And("I close browser")
    public void iCloseBrowser() {
        driver.close();
    }
}
