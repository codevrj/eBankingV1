package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class TC_login_001 extends BaseTest {

    @Test
    public void loginTest1(){

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(userName);
        lp.setPassWord(passWord);
        lp.clickLogin();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            System.out.println("Test case passed..");
        }else {
            System.out.println("Test case failed..");
            Assert.assertTrue(false);
        }
    }
}
