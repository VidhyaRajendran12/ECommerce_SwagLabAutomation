package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "user-name")
	WebElement userNamefield;

	@FindBy(id = "password")
	WebElement passwordfield;

	@FindBy(css = "[class*='error-message']")
	WebElement errorToast;

	@FindBy(id = "login-button")
	WebElement loginBtn;

	public void goToUrl() {
		driver.get("https://www.saucedemo.com/");
	}

	public void loginApp(String userName, String password) {

		userNamefield.sendKeys(userName);
		passwordfield.sendKeys(password);

	}

	public ProductsPage doLogin() {
		loginBtn.click();
		return new ProductsPage(driver);
	}

	public String getErrorToast() {
		// [class*='error-message']
		return errorToast.getText();

	}

}
