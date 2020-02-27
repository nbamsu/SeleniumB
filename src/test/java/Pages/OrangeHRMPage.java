package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMPage {
    public  OrangeHRMPage(WebDriver driver){
        /*
        initElement method takes two parameters
        one is driver another is page(this)
         */
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="txtUsername")
    public WebElement userName;
    @FindBy(id="txtPassword")
    public WebElement password;
    @FindBy(id="btnLogin")
    public WebElement loginButton;
    @FindBy(className = "page-title")
    public WebElement dashBoard;
    @FindBy(className = "dashboardCard-title-for-card")
    public WebElement retryLogIn;

}
