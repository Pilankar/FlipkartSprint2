package com.test;

import java.io.IOException;

public class LaunchBrowser extends Base {
	static String url = "https://www.flipkart.com/account/login";
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		getDriver();
		
		getUrl(url);
		
		maximize();
		
		//deleteCookies();
		
		
		FlipkartLogin loginPage = new FlipkartLogin();
		
		type(loginPage.getUserName(), getData(1,3));
		
		type(loginPage.getUserPsw(), decryptPsw(getData(1,4)));
		
		Thread.sleep(4000);
		
		btnClick(loginPage.getLoginBtn());
		
		//loginToFlipkart();
		
		//Thread.sleep(4000);
		
		System.out.println("Login Successful !!!");
		
		System.out.println("Welcome " + getData(1,1));
	
	}
}
