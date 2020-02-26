package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass

   {
	  @Test
      public void addNewCustomer() throws InterruptedException, IOException
      {
    	  LoginPage lp=new LoginPage(driver);
    	  lp.setUserName(username);
    	  
    	  logger.info("User name provided");
    	  lp.setPassword(password);
    	  
    	  logger.info("Password is provided");
    	  lp.clickSubmit();
    	  
    	  Thread.sleep(3000);
    	  
    	  AddCustomerPage addcust = new AddCustomerPage(driver);
    	  addcust.clickAddNewCustomer();
    	  
    	  addcust.custName("Tanya");
    	  addcust.custgender("female");
    	  Thread.sleep(3000);
    	  addcust.custdob("10", "15", "99");
    	  Thread.sleep(5000);
    	  addcust.custaddress("India");
    	  addcust.custcity("blr");
    	  addcust.custstate("kr");
    	  addcust.custpinno("500102");
    	  addcust.custatelephoneno("8365759607");
    	  
    	   String email = randomstring()+"@gmail.com";
    	   addcust.custemailid(email);
    	   addcust.custpassword("abcdeg");
    	   addcust.custsubmit();
    	   
    	   Thread.sleep(3000);
    	   
    	   logger.info("validation started.......");
    	  boolean res =  driver.getPageSource().contains("Customer Registered Successfully");
    	  
    	  if (res==true)
    	  {
    		  Assert.assertTrue(true);
    		  logger.info("test case passed.......");
    	  }
    	  
    	  else
    	  {
    		  logger.info("test case failed......");
    		  captureScreen(driver,"addNewCustomer");
    		  Assert.assertTrue(false);
    		  
    	  }
    	  
    	  
    	}
	  
  }
