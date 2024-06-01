package com.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	static String ProdName = "Sauce Labs Backpack";
	static WebDriver driver;

	public ProductsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[id*='title_link'] div")
	static
	List<WebElement> allProds;

	@FindBy(css = "[id*='add-to-cart']")
	static
	WebElement addToCartBtn;

	@FindBy(css = ".shopping_cart_link")
	static
	WebElement cartIcon;

	public static void prodAddtoCart() {
		for (int i = 0; i < allProds.size(); i++) {
			if (allProds.get(i).getText().equals(ProdName)) {
				addToCartBtn.click();
			}
		}
	}

	public static CartPage goToCart() {

		cartIcon.click();
		return new CartPage(driver);
}
	
	
}