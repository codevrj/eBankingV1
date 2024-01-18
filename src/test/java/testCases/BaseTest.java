package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.ReadConfig;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    public WebDriver driver;
    ReadConfig readConfig = new ReadConfig();
    String Url = readConfig.getUrl();
    String userName = readConfig.getUserName();
    String passWord = readConfig.getPassword();

    //public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String brw){

        if (brw.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (brw.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (brw.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        //logger = Logger.getLogger("E Banking App");
        //PropertyConfigurator.configure("log4j.properties");

        driver.manage().window().maximize();
        driver.get(Url);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        //System.exit(0);
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source,target);
        System.out.println("Screenshot taken...");
    }

    // Check if the Alert is present
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    // Random Text generation methods
    public String randomString() {    // Return random string...
        String generatedText = RandomStringUtils.randomAlphabetic(5);  // 5 random characters of string
        return generatedText;
    }

    public static String randomNum() {
        String generatedString = RandomStringUtils.randomNumeric(5);
        return generatedString;
    }
}
