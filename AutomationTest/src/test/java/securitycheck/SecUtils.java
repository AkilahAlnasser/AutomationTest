package securitycheck;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecUtils {
	

	public static final String low = new String("low");
	public static final String medium = new String("medium");
	public static final String XSS = new String("XSS");
	public static final String SQL = new String("sql");
	
	public static boolean isCMDIPresnets(WebDriver driver, String hacked) {

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

	public static boolean assertXSSVulnerablelevel(WebDriver driver, String SecLevel) {
		
		boolean foundAlert = false;
		
		if(SecUtils.low==SecLevel){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
			System.out.println("the Page is XSS low level Vulnerable");
		} catch (TimeoutException e) {
			foundAlert = false;
			System.out.println("the page is not low level XSS vulnerable");
		}
		}else if (SecUtils.medium=="medium")
		{

	
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
			System.out.println("the Page is XSS medium level Vulnerable");
		} catch (TimeoutException e) {
			foundAlert = false;
			System.out.println("the page is not medium medium XSS vulnerable");
		}
		}
		return foundAlert;
	}
	
	public static boolean assertVulnerable(WebDriver driver,String vulnerability, String SecLeve) {
		boolean vulnexist = false;
	
		if (vulnerability==SecUtils.XSS) {
			if(SecLeve==SecUtils.low) {
				
				assertXSSVulnerable(driver);
				vulnexist=true;
				System.out.println("page is vulnerable with low XSS flaw");
			}else if(SecLeve==SecUtils.medium) {
				
				assertXSSVulnerable(driver);
				vulnexist=true;
				System.out.println("page is vulnerable with medium XSS flaw");
			}
			
		}
		else if (vulnerability==SecUtils.SQL) {
			if(SecLeve==SecUtils.low) {
				
				assertXSSVulnerable(driver);
				vulnexist=true;
				System.out.println("page is vulnerable with low SQL flaw");
			}else if(SecLeve==SecUtils.medium) {
				
				assertXSSVulnerable(driver);
				vulnexist=true;
				System.out.println("page is vulnerable with medium SQL flaw");
			}
		}

		return vulnexist;
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
		 WebDriverWait wait1 = new WebDriverWait(driver, 10);
			try {
					
			 Alert alertclear = wait1.until(ExpectedConditions.alertIsPresent());

					if (alertclear != null) {
						findalert= true;
						System.out.println(message);
				
					}
			} catch (NoAlertPresentException e) {
				findalert=  false;
				System.out.println("alert not present");
				

			}
			return findalert ;
		

	}

	public static boolean assertCMDIvulnerable(WebDriver driver, String ip) {
		// TODO Auto-generated method stub
		boolean ipPresent;
		boolean getIP=driver.findElement(By.tagName("pre")).getText().contains(ip);
		if (getIP) {
			ipPresent = true;
			System.out.println("page is ipconfig vulnerable");
		} else {
			ipPresent = false;
			System.out.println("page is not ipconfig vulnerable");

			// System.out.println();
		}
		return ipPresent;
		}

	public static boolean assertCMDIechovulnerable(WebDriver driver, String echo) {
		// TODO Auto-generated method stub
		
		boolean getecho =driver.findElement(By.tagName("pre")).getText().contains(echo);
		boolean echoPresent;
		if (getecho) {
			echoPresent= true;
			System.out.println("page is echo command vulnerable");
		}else {
			echoPresent= false;
			System.out.println("page is not echo command vulnerable");
		
			
		}
		return echoPresent;
	}
	
}
