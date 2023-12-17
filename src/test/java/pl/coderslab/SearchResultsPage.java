package pl.coderslab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;

    @FindBy(className = "js-product")
    List<WebElement> articles;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    public void clickOnFirstProduct(){
        WebElement firstArticle = articles.get(0);
        WebElement articleLink = firstArticle.findElement(By.cssSelector("a"));
        articleLink.click();

    }
}




