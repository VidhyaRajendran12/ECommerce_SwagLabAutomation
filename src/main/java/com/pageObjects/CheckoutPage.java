package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	String ProdName = "Sauce Labs Backpack";
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "first-name")
	WebElement firstName;

	@FindBy(id = "last-name")
	WebElement lastName;

	@FindBy(id = "postal-code")
	WebElement postalCode;

	@FindBy(xpath = "//*[@id='continue']")
	WebElement continueBtn;

	public void enterUserInfo(String firstName1, String lastName1, String postalCode1) {
		firstName.sendKeys(firstName1);
		lastName.sendKeys(lastName1);
	postalCode.sendKeys(postalCode1);
	}

	public CheckoutOverviewPage clickContinue() {
		continueBtn.click();
	return new CheckoutOverviewPage(driver);
	}

}