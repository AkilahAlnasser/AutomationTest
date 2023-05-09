package securitycheck;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class XSSUtils {
	 //public static String XSS="xss";
	private static WebDriver driver;
	public static boolean isAlertPresent(WebDriver driver){
	    boolean foundAlert = false;
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        foundAlert = true;
	        System.out.println("alert is present");
	    } catch (TimeoutException e) {
	        foundAlert = false;
	        System.out.println("alert not present");
	    }
	    return foundAlert;
	}
	public static boolean assertVulnerable( WebDriver driver, String message) throws InterruptedException {
		// if vulnrabiltyt.xss then go to the level if the level. simple which
		//is ,script> alert() </script> if the alert not present then
		//retun true
//try it
		boolean alert= isAlertPresent(driver);
		if (alert==true) {
			try {//try begain
		//WebDriverWait wait1 = new WebDriverWait(driver, 10);
		//boolean alertIsPresent= ExpectedConditions.alertIsPresent() != null;
	
		// Assert.assertTrue(alert);
		
			// Alert alertclear = wait1.until(ExpectedConditions.alertIsPresent());
				// Thread.sleep(1000);
				// alertclear.accept();
				System.out.println(message);
			return true;
			
			
		} catch (TimeoutException e) {
			System.out.println("alert not present");
			        return false;
			        
			    }
		}
		
		return false;
	}

	  public static boolean AssertNotVulnerable(Object vuln) {
		  //boolean fail
		
		    if(vuln==vulnerabilty.XSS) {
		    	
		         return false ;
		    
		    	
		    }
		   return true;
		  }
	  
	
}//XSSUtils.AssertNotVulnerable(XSSUtils.XSS);
