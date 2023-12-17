package pl.coderslab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProceedToCheckoutPage {
    private WebDriver driver;

    public ProceedToCheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProceedButton() {
        WebElement proceedButton = this.driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        proceedButton.click();
    }
}
