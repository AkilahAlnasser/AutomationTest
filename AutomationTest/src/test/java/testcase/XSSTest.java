package testcase;

import javax.swing.text.html.parser.Element;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.j2objc.annotations.ReflectionSupport.Level;

import io.github.bonigarcia.wdm.WebDriverManager;
import securitycheck.XSSUtils;

public class XSSTest {
	 WebDriver driver;
	
  @Test
  public void testXSSReflected() throws InterruptedException {
	 //First testcase
	  driver.findElement(By.linkText("DVWA Security")).click();
	  Select drpCountry = new Select(driver.findElement(By.name("security")));
	  drpCountry.selectByValue("low");
	  driver.findElement(By.name("seclev_submit")).click();
	  
	 driver.findElement(By.linkText("XSS (Reflected)")).click();
	 driver.findElement(By.name("name")).sendKeys("<sCRiPt> alert(\"You have been hacked!\"); </script>");
	 driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/form/p/input[2]")).click();
	 
	 WebDriverWait wait = new WebDriverWait(driver, 10);
	 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	 Thread.sleep(1000);
	 alert.accept();
	 
	 driver.findElement(By.linkText("XSS (Stored)")).click();
	 driver.findElement(By.name("txtName")).sendKeys("crypto");
	 driver.findElement(By.name("mtxMessage")).sendKeys("<sCRiPt> alert(\"You have been hacked!\"); </script>");
	 driver.findElement(By.name("btnSign")).click();
	 

	 WebDriverWait wait1 = new WebDriverWait(driver, 10);
	 Alert alert1 = wait1.until(ExpectedConditions.alertIsPresent());
	 Thread.sleep(1000);
	 alert1.accept();
	 
	 driver.findElement(By.name("btnClear")).click();
	 WebDriverWait waitclear = new WebDriverWait(driver, 10);
	 Alert alertclear = wait1.until(ExpectedConditions.alertIsPresent());
	 Thread.sleep(1000);
	 alertclear.accept();
	 
	 driver.findElement(By.linkText("CSRF")).click();
	 //if the alert shown then the xss is present 
	 //if xss is present then assert is vulnerable and condition is false
	//XSSUtils.AssertNotVulnerable(false, "This page is Not vulnerable");
	//tils.assertNotVulnerable(Vulnerability.XSS, Level.SIMPLE);
	// XSSUtils.AssertNotVulnerable(alert present, lEVEL MUST be simple)
	
	 XSSUtils.AssertNotVulnerable(XSSUtils.XSS);
	 
  }
  
  
  @Test
  public void testXSSReStored()  {
	  
	  
	  
  
	  
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
