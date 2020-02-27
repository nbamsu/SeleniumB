package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class HerokuAppPage {
    public HerokuAppPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="file-upload")
    public WebElement chooseFile;
    @FindBy(id="file-submit")
    public WebElement uploadButton;
    @FindBy(xpath="//h3")
    public WebElement header;
    @FindBy(xpath = "//h3[.='File Uploaded!']")
    public WebElement header2;


    @FindBy(id = "uploadfile_0")
    public WebElement choosefile2;
    @FindBy(id = "submitbutton")
    public WebElement submiteButton;
    @FindBy(xpath = "//h3[@id='res']")
    public WebElement verify;

    @FindBy(xpath = "//a[.='Click Here']")
    public WebElement clickHereButton;


}
