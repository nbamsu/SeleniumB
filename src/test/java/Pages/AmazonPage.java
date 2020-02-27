package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonPage {
    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver("chrome"),this);
    }
    @FindBy(xpath = "//span[@class='a-price']")
    public List<WebElement>allPrice;
    @FindBy(xpath = "//span[@class='a-size-base']")
    public List<WebElement>fiveStar;
}
