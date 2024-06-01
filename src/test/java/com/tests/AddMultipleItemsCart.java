package com.tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testComponents.BaseTest;

public class AddMultipleItemsCart extends BaseTest {

//	public WebDriver driver;
	@Test
	public void AddMultipleItems() {
		landingPage.loginApp("standard_user", "secret_sauce");
		landingPage.doLogin();

		// Wait until the inventory items are present
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".inventory_item")));

		List<WebElement> allProds = driver.findElements(By.cssSelector(".inventory_item"));

		List<String> targetProducts = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light");

		for (WebElement product : allProds) {
			String productName = product.findElement(By.cssSelector(".inventory_item_name")).getText();
			System.out.println("Product found: " + productName); // Debugging line
			for (String targetProduct : targetProducts) {
				if (productName.equalsIgnoreCase(targetProduct)) {
					System.out.println("Adding to cart: " + productName); // Debugging line
					product.findElement(By.cssSelector("[id*='add-to-cart']")).click();
					break;
				}
			}
		}
	}

}