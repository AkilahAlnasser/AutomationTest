package securitycheck;

import org.testng.Assert;

public class XSSUtils {

	public static boolean assertVulnerable(boolean condition, String b) {
		// if vulnrabiltyt.xss then go to the level if the level. simple which
		//is ,script> alert() </script> if the alert not present then
		//retun true 
	//	a=a.toLowerCase();
		if (condition)
		{
			return true;
		}
		return false;
	}

	  public static void AssertNotVulnerable(boolean condition, String message) {
		    if(!condition) {
		       
		    	
		    }
		  }
	  
	
}
