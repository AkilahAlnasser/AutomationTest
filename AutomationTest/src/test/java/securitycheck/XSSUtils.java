package securitycheck;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class XSSUtils {
	public static String XSS="xss";
	public static boolean assertVulnerable( WebDriver driver) throws InterruptedException {
		// if vulnrabiltyt.xss then go to the level if the level. simple which
		//is ,script> alert() </script> if the alert not present then
		//retun true 
	//	a=a.toLowerCase();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		boolean alertIsPresent= ExpectedConditions.alertIsPresent() != null;
	
		 
		if (alertIsPresent)
		{
			 Alert alertclear = wait1.until(ExpectedConditions.alertIsPresent());
				 Thread.sleep(1000);
				 alertclear.accept();
			return false;
		}
		return true;
	}

	  public static boolean AssertNotVulnerable(Object vuln) {
		  //boolean fail
		
		    if(vuln==vulnerabilty.XSS) {
		    	
		         return false ;
		    
		    	
		    }
		   return true;
		  }
	  
	
}//XSSUtils.AssertNotVulnerable(XSSUtils.XSS);
