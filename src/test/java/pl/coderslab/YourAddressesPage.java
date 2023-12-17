package pl.coderslab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YourAddressesPage {
    private WebDriver driver;

    @FindBy(className = "address")
    private List<WebElement> addresses;

    public YourAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean addressIsVisible(){
        return !addresses.isEmpty();
    }

    public String getLastAddressAsText(){
        WebElement address = addresses.get(addresses.size() - 1);
        String text = address.getText();
        return text;
    }

    public void deleteLastAddress() {
        WebElement address = addresses.get(addresses.size() - 1);
        WebElement deleteButton = address.findElement(By.cssSelector("a[data-link-action=delete-address]"));
        deleteButton.click();
    }

    public Integer getAddressesSize(){
        Integer size = addresses.size();
        return size;
    }
}
