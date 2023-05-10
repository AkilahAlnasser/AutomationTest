package testcase;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;

public class Test2CSRF extends BaseTest{
	//WebDriver driver;
	
	
	  @Test
	  public void testCSRFLow() throws InterruptedException {
		
		  driver.findElement(By.linkText("DVWA Security")).click();
		  Select drpCountry = new Select(driver.findElement(By.name("security")));
		  drpCountry.selectByValue("low");
		  driver.findElement(By.name("seclev_submit")).click();
		  driver.findElement(By.linkText("CSRF")).click();
		  
		  driver.findElement(By.name("password_new")).sendKeys("hacked");
		  driver.findElement(By.name("password_conf")).sendKeys("hacked");
		  driver.findElement(By.name("Change")).click();
		  

		  
		 driver.findElement(By.xpath("//*[@id=\"test_credentials\"]/button")).click();
		 
		 
		 System.out.println(driver.getCurrentUrl());
		 String parentWindow = driver.getWindowHandle();
		 Set<String> handles =  driver.getWindowHandles();
		    for(String windowHandle  : handles)
		        {
		        if(!windowHandle.equals(parentWindow))
		           {
		           driver.switchTo().window(windowHandle);
		        //  <!--Perform your operation here for new window-->
		          //driver.close(); //closing child window
		  		 System.out.println(driver.getCurrentUrl());
		 		driver.findElement(By.name("username")).sendKeys("admin");
		 		driver.findElement(By.name("hacked")).sendKeys("hacked");
		 		driver.findElement(By.name("login")).click();
		          driver.switchTo().window(parentWindow); //cntrl to parent window
		           }
		        }

		  
		  
		  
	  }
	//  @BeforeClass
	 // public void open_browser() {

		  
	 // }
	  
	}