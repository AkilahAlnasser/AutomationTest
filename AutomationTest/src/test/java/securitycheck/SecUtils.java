package securitycheck;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecUtils {
	

	public static final String low = new String("low");
	public static final String medium = new String("medium");
	public static final String high = new String("high");
	public static final String XSS = new String("XSS");
	public static final String SQL = new String("sql");
	public static final String CSRF = new String("CSRF");
	public static final String CMDI = new String("command injection");
	
	public static boolean isCMDIPresnets(WebDriver driver, String hacked) {

		boolean test;
		boolean findtext = driver.findElement(By.tagName("pre")).getText().contains(hacked);

		if (findtext) {
			test = true;
			System.out.println("page is vulnerable");
		} else {
			test = false;
			System.out.println("page is not vulnerable");

	
		}
		return test;
	}

	public static boolean assertXSSVulnerable(WebDriver driver) {

		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			foundAlert = true;
			System.out.println("Page is Vulnerable");
		} catch (TimeoutException e) {
			foundAlert = false;
			System.out.println("page not Vulnerable");
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

				System.out.println("The page is vulnerable");

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

		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			foundAlert = true;
			System.out.println(message);
		} catch (TimeoutException e) {
			foundAlert = false;
			System.out.println("page is not vulnerable");
		}
		return foundAlert;

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
	
	public static void vulnerableUrl(WebDriver driver, boolean psswordCanged ) {
		
		if (psswordCanged) {
			
			System.out.println(driver.getCurrentUrl());
			System.out.println("The above URL is CSRF vulnerable");
		}
		else {
			
			System.out.println(driver.getCurrentUrl());
			System.out.println("The above URL is not CSRF vulnerable");
		}
	}

	public static boolean CSRFVulnerableFormExist(WebDriver driver, String filePath) throws IOException {
		// TODO Auto-generated method stub
			driver.get(filePath);
			boolean findlink=false;
try {
	
	findlink = driver.findElement(By.linkText("CSRFhacked.html")).isDisplayed();
	System.out.println("Page link is available");
} catch (TimeoutException e) {
	
	System.out.println("link not available");
}
	return findlink;
	    }

	public static boolean CMDIetcpasswodVulnerabilty(WebDriver driver, String injection) {
		// TODO Auto-generated method stub
		boolean isVuln= false;
		boolean result=driver.findElement(By.tagName("pre")).getText().contains("root");

		if (injection.contains("cat /etc/passwd")) {
			
			if(result) {
			isVuln=true;
				System.out.println("The page has access to /etc/passwd");
		}else
		{
				isVuln=false;
				System.out.println("The page has no access to /etc/passwd");}
			
		}
		return isVuln;
		}
	
	public static boolean CMDIwhoamiVulnerabilty(WebDriver driver, String expectedResult) {
		// TODO Auto-generated method stub
		boolean isVuln= false;
		boolean result=driver.findElement(By.tagName("pre")).getText().contains(expectedResult);

		
		if(result==true) 
			{
			isVuln=true;
				System.out.println("The page has accepted whoami command ");
		}else
		{
				isVuln=false;
				System.out.println("The page has not accepted whoami command or expected result defferent");}
			
		
		return isVuln;
		}
	// System.out.println();

	public static boolean assertCSPVulnerable(WebDriver driver) {
		// TODO Auto-generated method stub
		

			boolean foundAlert = false;
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			try {
				
				wait.until(ExpectedConditions.alertIsPresent());
				driver.switchTo().alert().accept();
				foundAlert = true;
				System.out.println("Page is CSP Vulnerable");
		
			
			
			} catch (TimeoutException e) {
				foundAlert = false;
				System.out.println("page not CSP present");
			}
			return foundAlert;
		
	}

	public static boolean assertSQLVulnerable(WebDriver driver, String injection) {
		// TODO Auto-generated method stu
		boolean result = true;
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='vulnerable_code_area']/pre"));
		for(int i=0; i<rows.size(); i++) {
			
			String getID=rows.get(i).getText().trim();
			String str[] = getID.split("\\R");
			System.out.println("=================================");
			System.out.println(str[0]);
			if(!(str[0].equalsIgnoreCase(injection))) {
				result= false;
			}
			
		}
		return result;
	}	
	
	
}
	

	
	

