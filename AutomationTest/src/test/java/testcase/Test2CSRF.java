package testcase;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseTest;
import securitycheck.SecUtils;

public class Test2CSRF extends BaseTest {
	// WebDriver driver;

	@Test
	public void testCSRFLow() throws InterruptedException, IOException {

		super.security("low");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("file:///C:/xampp/htdocs/CSRF/CSRFhacked.html");
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(1000);
		
		//SecUtils.CSRFVulnerableFormExist(driver, "file:///C:/xampp/htdocs/CSRF/CSRFhacked.html");
	WebElement np=	driver.findElement(By.name("password_new"));
	np.sendKeys("hacked");
		driver.findElement(By.name("password_conf")).sendKeys("hacaked");
		Thread.sleep(500);
		driver.findElement(By.name("Change")).click();
		Thread.sleep(1000);

		System.out.println(driver.getCurrentUrl()); // working

		WebDriverWait wait = new WebDriverWait(driver, 10);//
		WebElement tag = driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/pre"));
		System.out.println(tag.getText());
		wait.until(ExpectedConditions.visibilityOf(tag));
		Thread.sleep(1000);
		//boolean findtext = tag.getText().equalsIgnoreCase("password changed.");

		//SecUtils.isPasswordChanged(findtext);
		
	
			//SecUtils.CSRFVulnerableFormExist(driver,"http://localhost/CSRF");
	
	}

	@Test
	public void testCSRFMeduim() throws InterruptedException, FileNotFoundException {

		super.security("medium");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("file:///C:/xampp/htdocs/CSRF/CSRfhacked.html");
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(1000);

		driver.findElement(By.name("password_new")).sendKeys("hacked");
		driver.findElement(By.name("password_conf")).sendKeys("hacked");
		Thread.sleep(500);
		driver.findElement(By.name("Change")).click();
		Thread.sleep(1000);

		System.out.println(driver.getCurrentUrl()); // working

		WebDriverWait wait = new WebDriverWait(driver, 10);//
		WebElement tag = driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/pre"));
		System.out.println(tag.getText());
		wait.until(ExpectedConditions.visibilityOf(tag));
		Thread.sleep(1000);

		boolean findtext = tag.getText().equalsIgnoreCase("password changed.");

		SecUtils.isPasswordChanged(findtext);

	}

	@Test
	public void testCSRFlowUrl() throws InterruptedException {
		super.security("low");
		driver.get(
				"http://localhost/dvwa/vulnerabilities/csrf/?password_new=hacked&password_conf=hacked&Change=Change#");
		WebDriverWait wait = new WebDriverWait(driver, 10);//
		WebElement tag = driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/pre"));
		System.out.println(tag.getText());
		wait.until(ExpectedConditions.visibilityOf(tag));
		Thread.sleep(1000);
		boolean findtext = tag.getText().equalsIgnoreCase("password changed.");

		SecUtils.vulnerableUrl(driver, findtext);
	}

}