package pl.coderslab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseSize(String size){
        WebElement sizeSelect = this.driver.findElement(By.name("group[1]"));
        sizeSelect.click();
        sizeSelect.sendKeys(size);

    }

    public void changeQuantity(int quantity) {
        WebElement quantityUp = this.driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]"));
        for (int i = 1; i < quantity; i++) {
            quantityUp.click();
        }
    }

    public void clickAddToCard() {
        WebElement addToCardButton = this.driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
        addToCardButton.click();
    }
}
