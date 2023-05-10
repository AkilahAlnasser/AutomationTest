package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr ;//= new FileReader ();
	
	@BeforeTest
	public void setUp() throws IOException 
	{
		if(driver ==null) {
			
		 fr =new FileReader("C:\\Users\\akila\\git\\AutomationTest\\AutomationTest\\src\\test\\resources\\configFiles\\config.properties");
		 prop.load(fr);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 driver.get(prop.getProperty("testurl"));
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			 driver.get(prop.getProperty("testurl"));
		}
	}
	
	public void tearDown() 
	{
		
	}
	

}
