package testcase;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import securitycheck.SecUtils;

public class Test1XSS extends BaseTest{
	 
	
  @Test
  public void testXSSReflected() throws InterruptedException {

	 
		driver.findElement(By.linkText("DVWA Security")).click();
		Thread.sleep(500);
		Select drpCountry = new Select(driver.findElement(By.name("security")));
		drpCountry.selectByValue("low");
		Thread.sleep(500);
		driver.findElement(By.name("seclev_submit")).click();
		
	
		
	  
	 driver.findElement(By.linkText("XSS (Reflected)")).click();
	 Thread.sleep(500);
	 driver.findElement(By.name("name")).sendKeys("<script> alert('you have been hacked') </script>");
	 Thread.sleep(500);
	 driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/form/p/input[2]")).click();
	 
	 WebDriverWait wait = new WebDriverWait(driver, 10);
	 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	 
	 //SecUtils.assertXSSVulnerable(driver);
	 //SecUtils.assertXSSVulnerable(driver, "the page is vulnerable");
	//SecUtils.assertXSSVulnerable(driver,level.low);
	 alert.accept();
	 

	
	 //if the alert shown then the xss is present 
	 //if xss is present then assert is vulnerable and condition is false
	//XSSUtils.AssertNotVulnerable(false, "This page is Not vulnerable");
	//tils.assertNotVulnerable(Vulnerability.XSS, Level.SIMPLE);
	// XSSUtils.AssertNotVulnerable(alert present, lEVEL MUST be simple)
	
	
	
	 

}
	
  
  
  
  @Test
  public void testXSSReStored() throws InterruptedException  {
	  
		 
		 driver.findElement(By.linkText("XSS (Stored)")).click();
		 driver.findElement(By.name("txtName")).sendKeys("crypto");
		 //driver.findElement(By.name("mtxMessage")).sendKeys("<sCRiPt> alert(\"You have been hacked!\"); </script>");
		 //driver.findElement(By.name("btnSign")).click();
		 

		// WebDriverWait wait1 = new WebDriverWait(driver, 10);
		// Alert alert1 = wait1.until(ExpectedConditions.alertIsPresent());
		// assertThat(open_browser..isAlertDisplayed()).isFalse();
		// Thread.sleep(1000);
		 //alert1.accept();
		 
		// driver.findElement(By.name("btnClear")).click();
		 //Alert alertclear = wait1.until(ExpectedConditions.alertIsPresent());
		 //Thread.sleep(1000);
		// alertclear.accept();
	  

 
  }
  
}
  

