package testcase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import securitycheck.SecUtils;

public class Test5CSPBypass extends BaseTest{
	
	@Test
	public void CSPBypassLow() throws InterruptedException {
		
		super.security("low");	
	driver.findElement(By.linkText("CSP Bypass")).click();
	Thread.sleep(1000);
	driver.findElement(By.name("include")).sendKeys("http://localhhost/CSP.scss");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/form/input[2]")).click();
	Thread.sleep(500);
	
	SecUtils.assertCSPVulnerable(driver);
	
	
	
	
	}
}
