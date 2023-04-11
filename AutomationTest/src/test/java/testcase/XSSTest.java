package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XSSTest {
	 WebDriver driver;
	
  @Test
  public void testXSS() {
	 //First testcase
	  driver.findElement(By.linkText("XSS (Reflected)")).click();
  }
  @BeforeClass
  public void open_browser() {
	//WebDriverManager.chromedriver().setup();  
	 // System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.get("http://localhost/dvwa/");
  }
  
}
