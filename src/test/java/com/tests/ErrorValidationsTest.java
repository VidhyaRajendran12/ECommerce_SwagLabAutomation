package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.pageObjects.CartPage;
import com.pageObjects.ProductsPage;
import com.testComponents.BaseTest;
import com.testComponents.Retry;

public class ErrorValidationsTest extends BaseTest {

	SoftAssert sa = new SoftAssert();

	@Test(retryAnalyzer = Retry.class)
	public void LoginErrorValidation() {

		landingPage.loginApp("DummyUser1", "Dummypassword1");
		landingPage.doLogin();
		Assert.assertFalse(landingPage.getErrorToast().contains("Username and password do not"));
	}

	@Test
	public void ProdErrorValidation() {

		landingPage.loginApp("standard_user", "secret_sauce");
		ProductsPage productPage = landingPage.doLogin();

		productPage.prodAddtoCart();
		CartPage cartPage = productPage.goToCart();
		Assert.assertFalse(cartPage.getCartProdName().equals("Test"));

	}

}
