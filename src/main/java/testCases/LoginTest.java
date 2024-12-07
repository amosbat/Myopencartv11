package testCases;

import java.io.File;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import jdk.internal.org.jline.utils.Log;
import pageObjects.HomePage;



public class LoginTest {

public WebDriver driver;

public org.apache.logging.log4j.Logger logger;
	
	@BeforeClass
	void setUp() {
		
		logger = LogManager.getLogger(this.getClass());
		
		driver = new ChromeDriver();
		logger.info("Chrome setup is complete");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
	
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
		
	}
	
	
	@Test
	void Testlogin() throws InterruptedException {
				
	try {
		HomePage HP = new HomePage(driver);
	
		
		HP.username("Admin");
		Thread.sleep(2000);
		HP.password("admin123");
		Thread.sleep(2000);
		HP.loginbtn();
		Thread.sleep(2000);
		logger.info("logged into HomePage");
		
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Files.copy(f, new File(System.getProperty("user.dir") + "\\screenshots\\fullpage2.png"));
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		Thread.sleep(2000);
		logger.info("validate user login");
	}
	catch(Exception e) {
		logger.error("Test failed");
		logger.debug("Debug logs..");
		Assert.fail();
	}
}
}
