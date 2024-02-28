package Base;
 
 
import java.io.File;
//import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import java.util.List;
//import java.util.Properties;
// 
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.testng.ITestListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base{
 
	public static WebDriver driver ;
	public static Logger logger;
	
//	public static Logger getlogger()
//	{
//		logger=LogManager.getLogger();
////		return logger;
//	}
//   	
   	
	@BeforeClass
	@Parameters({"browsers"})
	public  void driverSetup(String browser) throws InterruptedException, IOException {
		logger =LogManager.getLogger(this.getClass());
		if(browser.equals("chrome")){
			//ChromeOptions option=new ChromeOptions();
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("Chrome Browser Launched Successfully");
			logger.info("started logs");
			
		}
		else if(browser.equals("edge")) {
			EdgeOptions option = new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(option);
			System.out.println("Edge Browser Launched Successfully");
		}
		

				
       		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.get("https://www.urbanladder.com/");
			driver.manage().window().maximize();

		}
	

 
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public static String screenShot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir") + "\\screenshots\\" + filename + ".png");
		FileUtils.copyFile(src, trg);
		return trg.getAbsolutePath();
	}
}