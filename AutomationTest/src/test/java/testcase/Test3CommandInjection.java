package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import securitycheck.SecUtils;

public class Test3CommandInjection extends BaseTest{
	boolean test = false;
	
	@Test
	public void commandInjectionLow() throws InterruptedException {
	driver.findElement(By.linkText("DVWA Security")).click();
	Select drpCountry = new Select(driver.findElement(By.name("security")));
	drpCountry.selectByValue("low");
	driver.findElement(By.name("seclev_submit")).click();
	System.out.println(driver.getCurrentUrl());
	
	driver.findElement(By.linkText("Command Injection")).click();
	driver.findElement(By.name("ip")).sendKeys("127.0.01 && whoami && echo \"you have been hacked\" ");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/form/p/input[2]")).click();
	
	WebDriverWait wait = new WebDriverWait(driver, 10);//
	WebElement tag = driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/pre"));
	System.out.println(tag.getText());
	wait.until(ExpectedConditions.visibilityOf(tag));
	Thread.sleep(1000);

	boolean findtext = tag.getText().contains("hacked");
	
	if (findtext) {
		test= true;
		System.out.println("page is vulnerable");
	}else {
		test= false;
		System.out.println("page is not vulnerable");
	
		//System.out.println();
	}
	
	}
	
	@Test
	public void commandInjectionmeduim() throws InterruptedException {
	driver.findElement(By.linkText("DVWA Security")).click();
	Select drpCountry = new Select(driver.findElement(By.name("security")));
	drpCountry.selectByValue("medium");
	driver.findElement(By.name("seclev_submit")).click();
	System.out.println(driver.getCurrentUrl());
	
	driver.findElement(By.linkText("Command Injection")).click();
	driver.findElement(By.name("ip")).sendKeys("127.0.01 & whoami & echo \"you have been hacked\" ");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/form/p/input[2]")).click();
	
	WebDriverWait wait = new WebDriverWait(driver, 10);//
	WebElement tag = driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/pre"));
	System.out.println(tag.getText());
	wait.until(ExpectedConditions.visibilityOf(tag));
	Thread.sleep(1000);
	
	SecUtils.CMPresnets(driver, "hacked");
	}
}
