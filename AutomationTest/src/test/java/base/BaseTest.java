package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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
			security("low");
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			 driver.get(prop.getProperty("testurl"));
		}
	}
	
	public void security(String level) {
		if (level=="low") {
		driver.findElement(By.linkText("DVWA Security")).click();
		Select drpCountry = new Select(driver.findElement(By.name("security")));
		drpCountry.selectByValue("low");
		driver.findElement(By.name("seclev_submit")).click();
		}
		else if (level=="medium") {
		driver.findElement(By.linkText("DVWA Security")).click();
		Select drpCountry = new Select(driver.findElement(By.name("security")));
		drpCountry.selectByValue("medium");
		driver.findElement(By.name("seclev_submit")).click();
		}
		
		
	}
	
	
	public void tearDown() 
	{
		
	}
	

}
