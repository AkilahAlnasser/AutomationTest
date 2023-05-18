package securitycheck;

import base.BaseTest;

abstract  class vulnerabilty extends BaseTest{
String xss;
String CSRF;


public static final String low = new String("low");
public static final Object SecLevel = new Object();

public vulnerabilty() {

	
}

public vulnerabilty(String xss) {
	this.xss= xss;
	//this.CSRF;
	
	
}
protected vulnerabilty(int a) {
	this.CSRF= CSRF;

	
	
}
}
