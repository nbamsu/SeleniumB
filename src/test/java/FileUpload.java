import Pages.HerokuAppPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload extends TestBase {
    @Test
    public void uploadFile(){
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        HerokuAppPage page=new HerokuAppPage(driver);
       String expectedHeader="File Uploader";
        String actualHeader= page.header.getText();
        Assert.assertEquals(expectedHeader,actualHeader);

        driver.navigate().to("http://demo.guru99.com/test/upload/");


    }

    @Test(dependsOnMethods = "uploadFile")
    public void uploadFile2(){
        HerokuAppPage page2=new HerokuAppPage(driver);
        //page2.chooseFile.click();
        page2.chooseFile.sendKeys("C:\\Users\\Nurkulov\\Downloads\\Java-JDK-Installation-And-Configuration (1).pdf");
        page2.uploadButton.click();
        String expected="File Uploaded!";
        String actual=page2.header2.getText();
        Assert.assertEquals(expected,actual);


    }
    @Test
       public void uploadBreak() {
        HerokuAppPage page3=new HerokuAppPage(driver);
        //page2.chooseFile.click();
        page3.choosefile2.sendKeys("C:\\Users\\Nurkulov\\Downloads\\breakUpload.png");
        page3.submiteButton.click();
        String expected="1 filehas been successfully uploaded.";

        String actual=page3.verify.getText();
        Assert.assertEquals(expected,actual);



    }

}
