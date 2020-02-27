package OrangeHRM;

import Pages.OrangeHRMPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogIn extends TestBase{
    public class LoginTest{
        @DataProvider(name="credentials")
        public Object[][]getData(){
            return new Object[][]{
                    {"admin","admin123"},
                    {"admin","123"},
                    {"ad","admin123"},
                    {"ad","ad"}
            };
        }
        @Test(dataProvider = "credentials")
        public void logInTest(String username,String password){
            OrangeHRMPage orangeHRMPage=new OrangeHRMPage(driver);
            driver.get("https://orangehrm-demo-6x.orangehrmlive.com/auth/login");

            orangeHRMPage.userName.clear();
            orangeHRMPage.userName.sendKeys(username);

            orangeHRMPage.password.clear();
            orangeHRMPage.password.sendKeys(password);
            orangeHRMPage.loginButton.click();

            if (username.equalsIgnoreCase("admin")&&password.equalsIgnoreCase("admin123")) {

                String expected = "Dashboard";
                String actual = orangeHRMPage.dashBoard.getText();
                Assert.assertEquals(expected, actual);
                driver.navigate().back();
            }else{
                String expected="Retry LogIn";
                String actual=orangeHRMPage.retryLogIn.getText();
                Assert.assertEquals(expected,actual);
                driver.navigate().back();
            }
        }
    }
}
