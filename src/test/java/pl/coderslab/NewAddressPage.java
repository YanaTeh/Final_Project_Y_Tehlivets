package pl.coderslab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {
    //atrybut
    private WebDriver driver;

    @FindBy(name = "firstname")
    private WebElement firstNameInput;

    @FindBy(name = "lastname")
    private WebElement lastNameInput;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "postcode")
    private WebElement postcodeInput;

    @FindBy(id = "field-id_country")
    private WebElement countrySelect;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/footer/button")
    private WebElement buttonSave;

    //constructor
    public NewAddressPage(WebDriver driver/*parametr*/){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }
    //metoda bezparametrowa
    public void fillData(String firstname, String lastname, String address, String city, String postcode, String country) {
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstname);

        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastname);

        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        postcodeInput.click();
        postcodeInput.clear();
        postcodeInput.sendKeys(postcode);

        countrySelect.click();
        countrySelect.sendKeys(country);
    }

    public void saveData(){
        buttonSave.click();
    }


}
