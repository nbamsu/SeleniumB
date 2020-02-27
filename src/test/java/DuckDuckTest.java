import Pages.DuckDuckGoPage;
import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class DuckDuckTest extends TestBase{
    @DataProvider(name="searchValues")
    public Object [][] getSearchValue(){
        return new Object[][]{
            {"selenium"},
            {"Docker"},
            {"Api"}
        };
    }

    @Test(dataProvider = "searchValues")
    public void testDuckGo(String searchValue){

        DuckDuckGoPage page=new DuckDuckGoPage(driver);
        driver.navigate().to("https://duckduckgo.com/");

        page.searchBox.sendKeys(searchValue);
        page.searchButton.click();
        String expectedTitle=searchValue+" at DuckDuckGo";
        String actualTitle=driver.getTitle();

        sa.assertEquals(actualTitle,expectedTitle);
       // Assert.assertEquals(actualTitle,expectedTitle);
        page.videoButton.click();

       // BrowserUtils.visibility(driver,page.videos.get(0),10);
        int actualCount=page.videos.size();
        sa.assertTrue(actualCount>29);
        sa.assertAll();

        //Assert.assertTrue(actualCount>29);
    }

    // i want to take screen shot if my test case is failed
    @AfterMethod
    public void takeScreenShot(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.FAILURE) {
            BrowserUtils.takeScreenShot(driver);
        }
    }

}
