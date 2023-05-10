package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test2CSRF {
	WebDriver driver;
	
	
	  @Test
	  public void testXSSReflected() throws InterruptedException {
		 //First testcase
		  driver.findElement(By.linkText("DVWA Security")).click();
		  Select drpCountry = new Select(driver.findElement(By.name("security")));
		  drpCountry.selectByValue("low");
		  driver.findElement(By.name("seclev_submit")).click();
	  }
	  @BeforeClass
	  public void open_browser() {
		//WebDriverManager.chromedriver().setup();  
		 System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("http://localhost/dvwa/");
		  Assert.assertTrue(driver.getTitle().contains("Damn"));
		  
	  }
	  
	}