package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XSSTest {
	 WebDriver driver;
	
  @Test
  public void testXSS() {
	 
  }
  @BeforeClass
  public void open_browser() {
	//WebDriverManager.chromedriver().setup();  
	 // WebDriver driver =new ChromeDriver();
	  System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");

	  driver.get("http://localhost/dvwa/");
  }
  @AfterClass
  public void close_browser()
  {
	 // driver.close();
  }
  
}
