package pl.coderslab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinalizationPage {
    private WebDriver driver;

    public FinalizationPage(WebDriver driver) {

        this.driver = driver;
    }

    public void confirmAddress() {
        WebElement confirmAddressButton = this.driver.findElement(By.name("confirm-addresses"));
        confirmAddressButton.click();
    }

    public void confirmShippingMethod() {
        WebElement confirmDeliveryOptionButton = this.driver.findElement(By.name("confirmDeliveryOption"));
        confirmDeliveryOptionButton.click();
    }

    public void choosePayByCheckOption() {
        WebElement paymentOption = this.driver.findElement(By.id("payment-option-1"));
        paymentOption.click();
    }

    public void agreeWithTerms() {
        WebElement checkAgree = this.driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        checkAgree.click();
    }

    public void placeOrder() {
        WebElement placeOrderButton = this.driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
        placeOrderButton.click();
    }
}
