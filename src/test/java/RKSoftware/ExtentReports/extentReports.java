package RKSoftware.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReports {
	
ExtentReports extent;
	
	@BeforeTest
	public void config() {
		//Extent reports  //ExtentSparkReporter
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Atomation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		
		extent = new ExtentReports();  //this is the main object, in this we are passing Extentsparkreporter object
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Pooja");
		
		}

	
	@Test
	public void initialDemo() {
         ExtentTest tests = extent.createTest("initial Demo"); 	//here tests object is optional without its code cn run, but if we create object we csn sccess to many methods.	
		
         System.setProperty("webdriver.chrome.driver", "C:/Users/Pooja/Desktop/selenium/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();
		tests.fail("Result do not match");  //explicitly we are failing our test.
		
		extent.flush();
	}

}
