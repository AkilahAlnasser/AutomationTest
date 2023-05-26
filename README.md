# AutomationTest
Java Library to faciliate atomation testing using selemnium

<img alt="image" src="https://github.com/zaraAlna/AutomationTest/assets/130008342/ad3f7709-9829-461a-b888-5bf7b8f58919"  width="75%" height="75%">



## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
What Software you need to install to run this project

```
Installing Java development toolkit (JDK) eclipse 
Installing XAPP to run the DVAW
Installing DVWA and set it up and change the setting to enable all the database setup
TestNg Framework was installing inside the JDK environment  

```
### Designing and implementation


 <ins> planning the design instructures as follow</ins>

<img src="images/Picture3.png" >


 <ins>After implemnting the design will be as follow</ins>
 
<img src="images/Picture5.png" width="40%" height="40%">




### The Setup

<ins>The following steps were applied to setup</ins>

<img src="https://user-images.githubusercontent.com/130008342/231166625-e8d3d5ee-179c-4a36-9994-acec7ebdbc7e.png" width="50%" height="50%">

<ins>Watch the setup video </ins>

[![Watch the video](https://img.youtube.com/vi/5MQOK7xD0O0/0.jpg)](https://www.youtube.com/watch?v=5MQOK7xD0O0 "Watch the video")

## Running the tests

Explain how to run the automated tests for this system
run the automation testcase</br>
<img src="images/Injection.png" width="60%" >
</br>
 Assert if the page is XSS vulnerable </br>

<img scr="images/result.png"  width="90%">

![image](https://github.com/AkilahAlnasser/AutomationTest/assets/130008342/fe265aa6-2c0c-483d-9f5f-6571f216effa)</br>
 Asserting echo command in command injection vulnerabilty</br>
![image](https://github.com/AkilahAlnasser/AutomationTest/assets/130008342/76457fcb-ee30-49d1-a698-dba907f554d6)</br>
same assertion but the command echo was missing</br>
![image](https://github.com/AkilahAlnasser/AutomationTest/assets/130008342/2f99b99a-a2e1-499c-acfc-fa9e857e88ac))</br>



### Break down into end to end tests

Explain what these tests test and why
End-to-end testing is a functional tese, that examine the test from beginning to the end. It is evaluate the wepapplication all the way from the biginning to the finish.
```
-Type the URL into the address bar to launch the Gmail login page.
-Log into the account with valid credentials.
-Access Inbox. Open Read and Unread emails.
-Compose a new email.
-Reply to and forward an existing email.
-Open the Sent items folder. Check emails there.
-Open the Spam folder. Check emails there.
-Log out of Gmail by clicking ‘logout’.
```

### And coding style tests

Explain what these tests test and why

```
SecUtils.assertXSSVulnerable(driver);
SecUtils.assertXSSVulnerable(driver, massege);
SecUtils.assertXSSVulnerable(driver, "There is a trace that this page is XSS vulnerable");
SecUtils.assertVulnerable(driver, SecUtils.XSS, SecUtils.low);
SecUtils.assertXSSVulnerablelevel(driver,SecUtils.low);
SecUtils.isPasswordChanged(findtext);
SecUtils.vulnerableUrl(driver, findtext);
SecUtils.assertCMDIvulnerable(driver,ip);// assert IP command
SecUtils.assertCMDIechovulnerable(driver,"you have been hacked");//assert echo command
SecUtils.isCMDIPresnets(driver, "hacked");
SecUtils.CMDIetcpasswodVulnerabilty(driver, injection);
SecUtils.CMDIwhoamiVulnerabilty(driver, expectedResult);
```



## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

