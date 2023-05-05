package securitycheck;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class XSSUtils {
	 //public static String XSS="xss";
	static WebDriver driver;
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
	public static boolean assertVulnerable( Object a) throws InterruptedException {
		// if vulnrabiltyt.xss then go to the level if the level. simple which
		//is ,script> alert() </script> if the alert not present then
		//retun true 
		if (a== vulnerabilty.XSS) {
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		//boolean alertIsPresent= ExpectedConditions.alertIsPresent() != null;
	
		 
		
			 Alert alertclear = wait1.until(ExpectedConditions.alertIsPresent());
				 Thread.sleep(1000);
				 alertclear.accept();
			return true;
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
