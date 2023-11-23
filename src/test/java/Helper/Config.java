package Helper;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Config {
	public static WebDriver driver;
	
	public static Actions actions;
	
	public static void initializeDriver () throws Exception {
		
		ChromeOptions options = new ChromeOptions ();
		options.addArguments("disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", Utils.getProperty("TestDriverPath"));
		driver = new ChromeDriver ();
		
	}
	
	public static void maxmizeWindow () {
		driver.manage().window().maximize();
		}
	
	public static void navigate (String URL) {
		Config.driver.get(URL);
	}
	
	public static void driverQuit() {
		driver.quit();
	}
	
	

}
