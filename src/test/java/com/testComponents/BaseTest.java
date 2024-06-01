package com.testComponents;

import java.io.File;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pageObjects.LandingPage;

public class BaseTest {
	
	public static WebDriver driver;
	public static LandingPage landingPage;

	public void InitializeBrowser() throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\resources\\GlobalData.properties");
		properties.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: properties.getProperty("browser");

		// properties.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
	}

	public List<HashMap<String, String>> getJsonDatatoMap(String filePath) throws IOException {

		// Read the Json to String:

		String jsonContent = FileUtils.readFileToString(new File(filePath));

		// StandardCharsets.UTF_8);
		// String to HashMap:
		// Jackson Data Bind:

		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		// map, map1

		return data;
	}

	@BeforeMethod
	public void LaunchApp() throws IOException {
		InitializeBrowser();
		landingPage = new LandingPage(driver);
		landingPage.goToUrl();
	}

	//@AfterMethod
	public void tearDown() {
		driver.close();
	}

	public String getScreenshot(String testCaseNam, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);
		File dessrc = new File(System.getProperty("user.dir") + "//reports//.png");

		FileUtils.copyFile(src, dessrc);

		return System.getProperty("user.dir") + "//reports//.png";

	}

}
