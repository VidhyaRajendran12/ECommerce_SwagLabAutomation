package com.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pageObjects.CartPage;
import com.pageObjects.CheckoutComplete;
import com.pageObjects.CheckoutOverviewPage;
import com.pageObjects.CheckoutPage;
import com.pageObjects.ProductsPage;
import com.testComponents.BaseTest;

public class SubmitOrder extends BaseTest {
	String ProdName = "Sauce Labs Backpack";

	@Test(dataProvider = "getData")
	public void EndtoEndFlow(HashMap<String, String> input) {

		landingPage.loginApp(input.get("email"), input.get("password"));
		ProductsPage productPage = landingPage.doLogin();

		ProductsPage.prodAddtoCart();
		CartPage cartPage = productPage.goToCart();

		Assert.assertEquals(cartPage.getCartProdName().trim(), ProdName);

		CheckoutPage checkoutPage = cartPage.clickCheckout();
		checkoutPage.enterUserInfo("Test", "User", "542456");
		CheckoutOverviewPage checkoutOverviewPage = checkoutPage.clickContinue();

		Assert.assertEquals(checkoutOverviewPage.checkoutProdName(), ProdName);
		CheckoutComplete checkoutComplete = checkoutOverviewPage.clickFinish();

		Assert.assertTrue(checkoutComplete.checkoutCompletemessage().equalsIgnoreCase("Thank you for your order!"));
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		// return new String[][] { { "standard_user", "secret_sauce" }, { "visual_user",
		// "secret_sauce" } };

		/*
		 * HashMap<String, String> map = new HashMap<String, String>();
		 * map.put("userName", "standard_user"); map.put("password", "secret_sauce");
		 * 
		 * HashMap<String, String> map1 = new HashMap<String, String>();
		 * map1.put("userName", "visual_user"); map1.put("password", "secret_sauce");
		 */

		List<HashMap<String, String>> data = 	getJsonDatatoMap(System.getProperty("user.dir") + "\\src\\test\\java\\com\\data\\SubmitOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}
}
