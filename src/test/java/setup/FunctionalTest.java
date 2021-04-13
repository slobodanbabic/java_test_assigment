package setup;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * <strong>FunctionalTest</strong> handles setup and teardown of WebDriver.
 * 
 * @author Kim Schiller
 */
public class FunctionalTest {

	protected static WebDriver driver;

	@BeforeAll
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		// use FF Driver
		driver = new FirefoxDriver();
	}

	@AfterAll
	public static void tearDown() {
		driver.close();
	}
}