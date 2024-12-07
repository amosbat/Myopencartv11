package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	
	
	
//constructor

	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
//locators https://www.opencart.com/index.php?route=common/home
	//https://www.opencart.com/index.php?route=cms/demo
	
By text_homename_loc = By.xpath("//a[@class='navbar-brand']");

By text_username_loc = By.xpath("//input[@placeholder='Username']");

By text_password_loc = By.xpath("//input[@placeholder='Password']");

By btn_login_loc = By.xpath("//button[@type='submit']");

//action methods

	public void username(String username) {
		driver.findElement(text_username_loc).sendKeys(username);
	}
	public void password(String password) {
		driver.findElement(text_password_loc).sendKeys(password);
	}
	public void loginbtn() {
		driver.findElement(btn_login_loc).click();
	}




}
