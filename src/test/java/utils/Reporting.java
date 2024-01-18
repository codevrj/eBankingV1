package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter {

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    public void onStart(ITestContext testContext){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // timestamp..
        String repName = "Test-Report-"+timeStamp+".html";
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName); // specify the location..
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml/");

        extent = new ExtentReports();

        //extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name","localhost");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("user","VJ");

        htmlReporter.config().setDocumentTitle("Inet Banking Test project");  // Title of the report
        htmlReporter.config().setReportName("Functional Test Automation Report"); // Name of the project
        //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onTestSuccess(ITestResult testResult){

        logger = extent.createTest(testResult.getName());  // create new entry in the report
        logger.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN));  // send passed information
    }

    public void onTestFailure(ITestResult testResult){
        logger=extent.createTest(testResult.getName()); // create new entry..
        logger.log(Status.FAIL,MarkupHelper.createLabel(testResult.getName(),ExtentColor.RED));

        String screenShotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testResult.getName()+".png";

        File file = new File(screenShotPath);

        if (file.exists()){
            try {
                logger.fail("Screenshot is below:"+ logger.addScreenCaptureFromPath(screenShotPath));
            }catch (Exception e){
                System.out.println("Error "+e.getMessage()+" occurred.");
            }
        }
    }

    public void onTestSkipped(ITestResult testResult){
        logger = extent.createTest(testResult.getName());
        logger.log(Status.SKIP,MarkupHelper.createLabel(testResult.getName(),ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext){
        extent.flush();
    }
}
