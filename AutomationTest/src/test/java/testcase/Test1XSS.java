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

public class Test1XSS extends BaseTest {

	@Test
	public void testXSSReflected() throws InterruptedException {

		super.security("low");

		driver.findElement(By.linkText("XSS (Reflected)")).click();
		Thread.sleep(500);
		driver.findElement(By.name("name")).sendKeys("<script> alert('you have been hacked') </script>");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"main_body\"]/div/div/form/p/input[2]")).click();
		

		 SecUtils.isAlertPresent(driver);
		

		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		 Thread.sleep(1000);
		 alert.accept();

			//SecUtils.isAlertPresent(driver);
		 //SecUtils.assertXSSVulnerable(driver);
		 //SecUtils.assertXSSVulnerable(driver, "There is a result that this page is XSS vulnerable");
		// SecUtils.assertVulnerable(driver, SecUtils.XSS, SecUtils.low);
		// SecUtils.assertXSSVulnerablelevel(driver,SecUtils.low);

		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		//alert.accept();
		

	}

	@Test
	public void testXSSReStored() throws InterruptedException {

		super.security("low");

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		driver.findElement(By.linkText("XSS (Stored)")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("btnClear")).click();

		Thread.sleep(1000);
		Alert alertclear = wait1.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(1000);
		alertclear.accept();
		driver.findElement(By.name("txtName")).sendKeys("crypto");
		Thread.sleep(1000);
		driver.findElement(By.name("mtxMessage")).sendKeys("<sCRiPt> alert(\"You have been hacked!\"); </script>");
		Thread.sleep(1000);
		driver.findElement(By.name("btnSign")).click();
		Thread.sleep(1000);

		Alert alert1 = wait1.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(500);

		//SecUtils.assertXSSVulnerable(driver, "stored XSS vulnerability");
		//SecUtils.assertXSSVulnerablelevel(driver, SecUtils.low);
		
		alert1.accept();

		driver.findElement(By.name("btnClear")).click();
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(1000);
		alertclear.accept();

	}

}
