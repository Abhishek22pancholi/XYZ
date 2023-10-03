package apiTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class Base {
	public static ExtentReports extent;
    public static ExtentTest extentTest;
    
    @BeforeSuite
    public void setExtent() {
    extent =new ExtentReports("./Reports/ExtentReport.html");
    }
    @BeforeMethod
    public void startTest() {
    extent.endTest(extentTest);
    }
    @AfterMethod
    public void endTest() {
    extent.endTest(extentTest);
    }
    @AfterSuite
    public void endReport() {
    extent.flush();
    extent.close();
    }
}

