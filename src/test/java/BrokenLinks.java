import Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks extends TestBase {


    @Test
    public void testBrokenLinks(){
        driver.get("https://www.softwaretestingmaterial.com/generate-extent-reports/");
        List<WebElement> links=driver.findElements(By.xpath("//a"));
        System.out.println(links.size());
        for (WebElement link:links){
            System.out.println();
            String hreflink=link.getAttribute("href");
            //System.out.println(link.getAttribute("href"));
            BrowserUtils.verifyBrokenLink(hreflink);
        }

    }
}
