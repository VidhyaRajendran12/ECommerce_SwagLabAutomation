package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete {

	String ProdName = "Sauce Labs Backpack";
	WebDriver driver;

	public CheckoutComplete(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".complete-header")
	WebElement SuccessMessage;

	public String checkoutCompletemessage() {
		return SuccessMessage.getText();
	}
}