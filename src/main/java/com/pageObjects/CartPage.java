package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	String ProdName = "Sauce Labs Backpack";
	WebDriver driver;

	public CartPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".inventory_item_name")
	WebElement cartProdName;
	
	@FindBy(css = ".inventory_item_name")
	List<WebElement> cartAllProdName;

	@FindBy(id = "checkout")
	WebElement checkoutBtn;

//String yourCartProdName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();

	public String getCartProdName() {
		return cartProdName.getText();
	}
	
	

	public CheckoutPage clickCheckout() {
		checkoutBtn.click();
		return new CheckoutPage(driver);

	}

}