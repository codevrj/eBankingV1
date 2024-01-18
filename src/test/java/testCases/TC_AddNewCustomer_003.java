package testCases;

import org.testng.annotations.Test;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

import java.io.IOException;

public class TC_AddNewCustomer_003 extends BaseTest {

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {

        LoginPage lp = new LoginPage(driver); // To login application
        lp.setUserName(userName);
        lp.setPassWord(passWord);
        lp.clickLogin();

        Thread.sleep(3000);

        AddCustomerPage ncus = new AddCustomerPage(driver);  // To add new customer

        ncus.clickAddCustomer();
        ncus.setCusName("");
        ncus.setGenderM();
        ncus.setDob("", "", "");
        Thread.sleep(3000);
        ncus.setAddress("");
        ncus.setCity("");
        ncus.setState("");
        ncus.setPin("");
        ncus.setTelephone("");

        String email = randomString()+"@gmail.com"+BaseTest.randomNum();

        ncus.setEmail(email);
        ncus.setPassword("123abc");
        ncus.clickSubmit();

        Thread.sleep(3000);


        // Validations here
        boolean tle = driver.getPageSource().contains("Registered successfully");
        if (tle){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
            captureScreen(driver,"AddNewCustomer");
        }
    }
}
