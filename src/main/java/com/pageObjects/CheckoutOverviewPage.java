package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {

	String ProdName = "Sauce Labs Backpack";
	WebDriver driver;

	public CheckoutOverviewPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "#finish")
	WebElement finishBtn;

	@FindBy(css = ".inventory_item_name")
	WebElement checkoutProdName;

	public String checkoutProdName() {
		return checkoutProdName.getText();
	}
	public CheckoutComplete clickFinish() {
		finishBtn.click();
		return new CheckoutComplete(driver);
	}

}