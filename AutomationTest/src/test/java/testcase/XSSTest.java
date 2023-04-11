package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class XSSTest {
	 WebDriver driver;
	
  @Test
  public void testXSS() {
	 
  }
  @BeforeClass
  public void open_browser() {
	  
	  System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.get("http://localhost/dvwa/");
  }
  
}
