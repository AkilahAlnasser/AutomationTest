package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import securitycheck.XSSUtils;

public class XSSTest {
	 WebDriver driver;
	
  @Test
  public void testXSS() {
	 //First testcase
	  driver.findElement(By.linkText("DVWA Security")).click();
	  Select drpCountry = new Select(driver.findElement(By.name("security")));
	  drpCountry.selectByValue("low");
	  driver.findElement(By.name("seclev_submit")).click();
	  
	 driver.findElement(By.linkText("XSS (Reflected)")).click();
	 driver.findElement(By.name("name")).sendKeys("<sCRiPt> alert(\"You have been hacked!\"); </script>");
	 driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/form/p/input[2]")).click();
	 //if the alert shown then the xss is present 
	 //if xss is present then assert is vulnerable and condition is false
	XSSUtils.AssertNotVulnerable(false, "This page is Not vulnerable");
  }
  @BeforeClass
  public void open_browser() {
	//WebDriverManager.chromedriver().setup();  
	 System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://localhost/dvwa/");
  }
  
}
