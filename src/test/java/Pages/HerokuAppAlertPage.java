package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppAlertPage {

        public HerokuAppAlertPage(WebDriver driver){
            /*
            we need constructor to crate object from page class
            PageFActory to be able to initialize my elements
            We need to give parameter argument of Webdriver because initElements method
            is taking two parameter (driver, this)
            "this" keyword refer the page itself
             */
            PageFactory.initElements(driver,this);

    }
        @FindBy(xpath = "//button[@onclick='jsAlert()']")
        public WebElement jsAlert;
        @FindBy(xpath = "//button[@onclick='jsConfirm()']")
        public WebElement jsConfirm;

        @FindBy(xpath = "//button[@onclick='jsPrompt()']")
        public WebElement jsPromt;

        @FindBy(xpath = "//h4")
        public WebElement resultHeader;
        @FindBy(id = "result")
        public WebElement resultText;

        @FindBy(xpath = "//h4//following-sibling::button")
    public WebElement showNormalAlert;
        @FindBy(xpath = "//pre[@data-example-id='sweetAlert']//preceding-sibling::button")
        public WebElement showSuccessMessage;
        @FindBy(xpath = "//button[.='OK']")
        public WebElement OK;
}
