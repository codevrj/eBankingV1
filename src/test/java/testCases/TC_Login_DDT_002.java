package testCases;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import utils.XLUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_Login_DDT_002 extends BaseTest {

    @Test(dataProvider = "LoginDataProvider")
    public void loginTest(String un, String pw) throws Exception {

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(un);
        //logger.info("Username Entered");
        lp.setPassWord(pw);
        //logger.info("Password Entered");

        lp.clickLogin();
        //logger.info("Login clicked");

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        if (!isAlertPresent()) {
            //logger.info("Successfully Logged...");
            lp.clickLogout();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        } else {
            //logger.warn("Invalid Login");
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }
    }
    String path = System.getProperty("user.dir") + "/src/test/java/testData/LoginData.xlsx";
    String xlsheet = "Sheet1";

    XLUtils dt = new XLUtils(path);

    // Data provider..
    @DataProvider(name = "LoginDataProvider")
    public String[][] getData() throws IOException {

        // Get data from the Excel file
        int totRows = dt.getRowCount(xlsheet);
        int totCols = dt.getCellCount(xlsheet, 1);

        String loginData[][] = new String[totRows][totCols];

        for (int i = 1; i <= totRows; i++) {
            for (int j = 0; j < totCols; j++) {
                loginData[i - 1][j] = dt.getCellData(xlsheet, i, j);
            }
        }
        return loginData;
    }
}
