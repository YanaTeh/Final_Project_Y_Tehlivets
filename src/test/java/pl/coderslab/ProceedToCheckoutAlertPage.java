package pl.coderslab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProceedToCheckoutAlertPage {
    private WebDriver driver;

    public ProceedToCheckoutAlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProceedButton() {
        WebElement button = this.driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        button.click();
    }
}
