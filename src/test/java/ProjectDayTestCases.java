import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProjectDayTestCases {
    private static WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    @Test
    public void addEmployeeNegative10(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        WebElement login=driver.findElement(By.id("txtUsername"));
          login.sendKeys("admin");

          WebElement password=driver.findElement(By.id("txtPassword"));
          password.sendKeys("admin123"+ Keys.ENTER);

          WebElement admin=driver.findElement(By.id("menu_admin_viewAdminModule"));
          admin.click();
//          WebElement user=driver.findElement(By.id("menu_admin_UserManagement"));
//          user.click();

        WebElement addEmployee=driver.findElement(By.id("btnAdd"));
        addEmployee.click();

        WebElement userRole=driver.findElement(By.id("systemUser_userType"));
        userRole.click();

        WebElement employeeName=driver.findElement(By.id("systemUser_employeeName_empName"));
        employeeName.sendKeys("Ariet Stamov");

        WebElement userName=driver.findElement(By.id("systemUser_userName"));
        userName.sendKeys("Ariet");

        WebElement status=driver.findElement(By.id("systemUser_status"));
        status.click();

        WebElement passsword=driver.findElement(By.id("systemUser_password"));
        passsword.sendKeys("ariet121212");

        WebElement confirm=driver.findElement(By.id("systemUser_confirmPassword"));
        confirm.sendKeys("ariet121212");

        WebElement save=driver.findElement(By.id("btnSave"));
        save.click();

        WebElement invalidName=driver.findElement(By.xpath("//input[@id='systemUser_employeeName_empId']//preceding::span[@class='validation-error']"));
        Assert.assertTrue(invalidName.isDisplayed());


    }


    @Test
    public void deleteEmployee11(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

        WebElement login=driver.findElement(By.id("txtUsername"));
          login.sendKeys("admin");

          WebElement password=driver.findElement(By.id("txtPassword"));
          password.sendKeys("admin123"+ Keys.ENTER);

          WebElement pim=driver.findElement(By.id("menu_pim_viewPimModule"));
          pim.click();

          WebElement listEmployee=driver.findElement(By.id("menu_pim_viewEmployeeList"));
          listEmployee.click();

          List<WebElement> checkBox=driver.findElements(By.xpath("//input[@type='checkbox']"));

            for (int i=0;i<checkBox.size();i++){
               checkBox.get(i).click();
               break;

        }


         WebElement deletButton=driver.findElement(By.id("btnDelete"));
         deletButton.click();


        WebElement okButton=driver.findElement(By.id("dialogDeleteBtn"));
        //okButton.click();   //input[@type='checkbox']  //input[@type='checkbox']

        List<WebElement> checkBoxafterdelete=driver.findElements(By.xpath("//input[@name='chkSelectRow[]']"));
        System.out.println(checkBox.size());
        System.out.println(checkBoxafterdelete.size());
        Assert.assertTrue(checkBox.size()>checkBoxafterdelete.size());





        }


        @Test
    public void Assign12(){
        //passed all true
            driver.get("https://opensource-demo.orangehrmlive.com/");
            driver.manage().window().maximize();

            WebElement login=driver.findElement(By.id("txtUsername"));
            login.sendKeys("admin");

            WebElement password=driver.findElement(By.id("txtPassword"));
            password.sendKeys("admin123"+ Keys.ENTER);

            WebElement leave=driver.findElement(By.id("menu_leave_viewLeaveModule"));
            leave.click();

            WebElement assignButton=driver.findElement(By.id("menu_leave_assignLeave"));
            assignButton.click();

            WebElement assignBar=driver.findElement(By.id("assignleave_txtEmployee_empName"));
            assignBar.clear();
            assignBar.sendKeys("Linda Anderson"+ Keys.ENTER);

            //don't know how to inspect drop down menu!!
            WebElement LeaveType=driver.findElement(By.id("assignleave_txtLeaveType"));
            LeaveType.click();
            LeaveType.sendKeys("V"+Keys.ENTER);


                WebElement fromdate=driver.findElement(By.id("assignleave_txtFromDate"));
                fromdate.clear();
                fromdate.sendKeys("2020-02-25");


                WebElement toDate=driver.findElement(By.id("assignleave_txtToDate"));
                toDate.clear();
                toDate.sendKeys("2020-03-10");

                WebElement assingConfirm=driver.findElement(By.id("assignBtn"));
                assingConfirm.click();

                WebElement balanceNotSufficient=driver.findElement(By.xpath("//div[@id='assignleave_leaveBalance']"));
                Assert.assertTrue(balanceNotSufficient.isDisplayed());

    }




    @Test
    public void AssignInvalidName13(){
        //passed input Name not from the list
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

            WebElement login=driver.findElement(By.id("txtUsername"));
            login.sendKeys("admin");

            WebElement password=driver.findElement(By.id("txtPassword"));
            password.sendKeys("admin123"+ Keys.ENTER);

            WebElement leave=driver.findElement(By.id("menu_leave_viewLeaveModule"));
            leave.click();

            WebElement assignButton=driver.findElement(By.id("menu_leave_assignLeave"));
            assignButton.click();

            WebElement assignBar=driver.findElement(By.id("assignleave_txtEmployee_empName"));
            assignBar.clear();
            assignBar.sendKeys("Aisanat Apasova"+Keys.ENTER);


            WebElement LeaveType=driver.findElement(By.id("assignleave_txtLeaveType"));
            LeaveType.click();
              LeaveType.sendKeys("V"+Keys.ENTER);


                WebElement fromdate=driver.findElement(By.id("assignleave_txtFromDate"));
                fromdate.clear();
                fromdate.sendKeys("2020-02-25");


                WebElement toDate=driver.findElement(By.id("assignleave_txtToDate"));
                toDate.clear();
                toDate.sendKeys("2020-03-10");

                WebElement assingConfirm=driver.findElement(By.id("assignBtn"));
                assingConfirm.click();

                WebElement invalid=driver.findElement(By.xpath("//span[.='Invalid']"));
                Assert.assertTrue(invalid.isDisplayed());

    }



    @Test
    public void EmptyLeaveType14(){
        //passed Assign to vacation
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

            WebElement login=driver.findElement(By.id("txtUsername"));
            login.sendKeys("admin");

            WebElement password=driver.findElement(By.id("txtPassword"));
            password.sendKeys("admin123"+ Keys.ENTER);

            WebElement leave=driver.findElement(By.id("menu_leave_viewLeaveModule"));
            leave.click();

            WebElement assignButton=driver.findElement(By.id("menu_leave_assignLeave"));
            assignButton.click();

            WebElement assignBar=driver.findElement(By.id("assignleave_txtEmployee_empName"));
            assignBar.clear();
            assignBar.sendKeys("Linda Anderson");

//        WebElement assignBar3=driver.findElement(By.id("assignleave_txtEmployee_empName"));
//        assignBar3.clear();
//        assignBar3.sendKeys("Linda Anderson"+ Keys.ENTER);

                WebElement fromdate=driver.findElement(By.id("assignleave_txtFromDate"));
                fromdate.clear();
                fromdate.sendKeys("2020-02-25");

try {
    WebElement toDate = driver.findElement(By.id("assignleave_txtToDate"));
    toDate.clear();
    toDate.sendKeys("2020-03-10");
    Thread.sleep(2000);
}catch (Exception e){
    System.out.println("Exception");
}

                WebElement commentBox=driver.findElement(By.id("assignleave_txtComment"));
                commentBox.sendKeys("Aisanat tell me please, why search");
                WebElement assignConfirm=driver.findElement(By.xpath("//input[@id='assignBtn']"));
                assignConfirm.click();

                WebElement required=driver.findElement(By.xpath("//span[.='Required']"));
                Assert.assertTrue(required.isDisplayed());

    }





    @Test
    public void dowloadDataInvalidName15(){

        //Click button not working

        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

            WebElement login=driver.findElement(By.id("txtUsername"));
            login.sendKeys("admin");

            WebElement password=driver.findElement(By.id("txtPassword"));
            password.sendKeys("admin123"+ Keys.ENTER);

            WebElement maintenance=driver.findElement(By.id("menu_maintenance_purgeEmployee"));
            maintenance.click();

            WebElement accessRecord=driver.findElement(By.id("menu_maintenance_accessEmployeeData"));
            accessRecord.click();


try{
            WebElement passwordConfirm=driver.findElement(By.id("confirm_password"));
            passwordConfirm.sendKeys("admin123"+Keys.ENTER);
            Thread.sleep(2000);



            WebElement searchBar=driver.findElement(By.id("employee_empName"));
            searchBar.sendKeys("Robert Graig");
          Thread.sleep(2000);



            WebElement search=driver.findElement(By.xpath("//input[@class='search_employee']"));
            Actions action=new Actions(driver);
            action.moveToElement(search).click().build().perform();
          //  search.click();




            }catch (Exception e){
    System.out.println("Got Exception");
        }
    }


    @Test
    public void downloadDataValideName16()  {
            driver.get("https://opensource-demo.orangehrmlive.com/");
            driver.manage().window().maximize();

            WebElement login=driver.findElement(By.id("txtUsername"));
            login.sendKeys("admin");

            WebElement password=driver.findElement(By.id("txtPassword"));
            password.sendKeys("admin123"+ Keys.ENTER);

        try{
            WebElement maintenance=driver.findElement(By.id("menu_maintenance_purgeEmployee"));
            maintenance.click();
            Thread.sleep(3000);


            WebElement accessRecord=driver.findElement(By.id("menu_maintenance_accessEmployeeData"));
            accessRecord.click();
            Thread.sleep(3000);



            WebElement passwordConfirm=driver.findElement(By.id("confirm_password"));
            passwordConfirm.sendKeys("admin123");
            Thread.sleep(3000);

            WebElement confirmButton=driver.findElement(By.xpath("//input[@type='submit']"));
            confirmButton.click();
            Thread.sleep(3000);



            WebElement searchBar=driver.findElement(By.id("employee_empName"));
            searchBar.sendKeys("Robert Graig"+Keys.ENTER);
            Thread.sleep(3000);


            WebElement search=driver.findElement(By.xpath("//input[@class='search_employee']"));
            search.click();
            Thread.sleep(3000);





            WebElement download=driver.findElement(By.xpath("//input[@id='btnDelete']"));
            Actions action=new Actions(driver);
            action.moveToElement(download).click().build().perform();
            //download.click();

            WebElement confirmDowload=driver.findElement(By.id("modal_confirm"));
            confirmDowload.click();

    }catch (Exception e){
        System.out.println("I cought");
    }
    }
    }

