
import Pages.HerokuAppPage;
import Utils.BrowserUtils;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandlePractice extends TestBase {
    @Test(priority = 1)
    public void windowHandle(){
        driver.get("https://the-internet.herokuapp.com/windows");
        HerokuAppPage page=new HerokuAppPage(driver);
        page.clickHereButton.click();

        System.out.println(driver.getTitle());
        String mainWindow=driver.getWindowHandle();
        Set<String> allWindows=driver.getWindowHandles();

        for (String window:allWindows){
            if (!mainWindow.equals(window)){
            driver.switchTo().window(window);
                System.out.println("After switch" + driver.getTitle());
            }
        }
        System.out.println("After switching" +driver.getTitle());

    }

    @Test(priority = 2)
    public void switchTitle1(){
        driver.get("https://the-internet.herokuapp.com/windows");
        HerokuAppPage page=new HerokuAppPage(driver);
        System.out.println(driver.getTitle()+" Before switch");

        page.clickHereButton.click();
        String mainWindow=driver.getWindowHandle();

        System.out.println("After switch "+driver.getTitle());

        BrowserUtils.switchWindow(driver,"New Window");

        System.out.println("After switch "+driver.getTitle());

        driver.switchTo().window(mainWindow);



    }
}
