package pl.coderslab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class YourAccountPage {
    private WebDriver driver;


    public YourAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddFirstAddressTile() {
        List<WebElement> firstAddressTile = this.driver.findElements(By.id("address-link"));

        if (!firstAddressTile.isEmpty()) {
            WebElement webElement = firstAddressTile.get(0);
            webElement.click();
        } else{
            WebElement addressesTile = this.driver.findElement(By.id("addresses-link"));
            addressesTile.click();
            WebElement createNewAddress = this.driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a"));
            createNewAddress.click();
        }
    }


    public void searchFor(String productName) {
        WebElement searchInput = this.driver.findElement(By.cssSelector("input[placeholder=\"Search our catalog\"]"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(productName);
        searchInput.submit();
    }
}
