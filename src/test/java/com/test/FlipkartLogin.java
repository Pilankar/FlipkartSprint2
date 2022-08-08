package com.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartLogin extends Base {
	/*
	 * Separate Locators for FaceBook login 
	 * */
	
	public FlipkartLogin() {
		//writing logic to pull all locators to contructor 
		//automatically initialize all the locators
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	private WebElement UserName;

	@FindBy(xpath="//input[@type='password']")
	private WebElement UserPsw;
	
	@FindBy(xpath="//div[@class='_1D1L_j']//button[@type='submit']")
	private WebElement LoginBtn;

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getUserPsw() {
		return UserPsw;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
}
