package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class DuckDuckGoPage {
    public DuckDuckGoPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(id = "search_form_input_homepage")
    public WebElement searchBox;
    @FindBy(id = "search_button_homepage")
    public WebElement searchButton;
    @FindBy(xpath = "//a[@class='zcm__link  js-zci-link  js-zci-link--videos']")
    public WebElement videoButton;
    @FindBy(xpath = "//div[@class='tile  tile--c--w  tile--vid  has-detail  opt--t-xxs']")
    public List<WebElement> videos;
}
