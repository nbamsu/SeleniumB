import Pages.HerokuAppAlertPage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertPractice extends TestBase {
    @Test(priority = 1)
    public void firstAlert() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        HerokuAppAlertPage page = new HerokuAppAlertPage(driver);

        page.jsAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println(page.resultHeader.getText());

    }

    @Test(priority = 2)
    public void firstAlertjsConfirm() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        HerokuAppAlertPage page = new HerokuAppAlertPage(driver);
        page.jsConfirm.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        String expected = "Cancel";
        String actual = page.resultText.getText();

        Assert.assertTrue(actual.contains(expected));

    }

    @Test(priority = 3)
    public void firstAlertjsPromt() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        HerokuAppAlertPage page = new HerokuAppAlertPage(driver);

        page.jsPromt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Makarony");
        alert.accept();

        String expected = "Makarony";
        String actual = page.jsPromt.getText();

        Assert.assertTrue(actual.endsWith(expected));


    }

    @Test(priority = 4)
    public void sweetAlert() {
        driver.get("https://sweetalert2.github.io/");
        HerokuAppAlertPage page = new HerokuAppAlertPage(driver);
        page.showNormalAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();


    }

    @Test(priority = 5)
    public void sweetAlert2() {
        driver.get("https://sweetalert2.github.io/");
        HerokuAppAlertPage page = new HerokuAppAlertPage(driver);
        page.showSuccessMessage.click();
        page.OK.click();


    }
}