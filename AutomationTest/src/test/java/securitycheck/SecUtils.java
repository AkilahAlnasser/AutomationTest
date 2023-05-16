package securitycheck;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecUtils {

	public static boolean CMPresnets(WebDriver driver, String hacked) {

		boolean test;
		boolean findtext = driver.findElement(By.tagName("pre")).getText().contains(hacked);

		if (findtext) {
			test = true;
			System.out.println("page is vulnerable");
		} else {
			test = false;
			System.out.println("page is not vulnerable");

			// System.out.println();
		}
		return test;
	}

	public static boolean assertXSSVulnerable(WebDriver driver) {

		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
			System.out.println("Page is Vulnerable");
		} catch (TimeoutException e) {
			foundAlert = false;
			System.out.println("alert not present");
		}
		return foundAlert;
	}

	public static boolean AssertNotVulnerable(Object vuln) {
		// boolean fail

		if (vuln == vulnerabilty.XSS) {

			return false;

		}
		return true;
	}

	public static boolean isPasswordChanged(boolean foundtag) {

		try {

			if (foundtag) {

				System.out.println("the site is vulnerable");

			} else {
				foundtag = false;
				System.out.println("password didn't change");
			}
		} catch (TimeoutException e) {

			System.out.println("timeout no result");

		}
		return foundtag;

	}

	public static boolean assertXSSVulnerable(WebDriver driver, String message) throws InterruptedException {
		// if vulnrabiltyt.xss then go to the level if the level. simple which
		// is ,script> alert() </script> if the alert not present then
		// retun true
//try it
		boolean findalert =false;
	
			try {// try begain
					 WebDriverWait wait1 = new WebDriverWait(driver, 10);
			 Alert alertclear = wait1.until(ExpectedConditions.alertIsPresent());
			 Thread.sleep(1000);
				 alertclear.accept();
					if (alertclear != null) {
				System.out.println(message);
				findalert= true;
					}
			} catch (NoAlertPresentException e) {
				System.out.println("alert not present");
				findalert=  false;

			}
			return findalert ;
		

	}
}// XSSUtils.AssertNotVulnerable(XSSUtils.XSS);
