package TestSuites;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import Helper.Config;
import Helper.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;


public class CommunStepDef {
	@Given("admin is on HomePage")
	public void admin_is_on_home_page() throws Exception {
	   Config.initializeDriver();
	   Config.navigate(Utils.getProperty("Web_Portal_Link"));
	   Config.maxmizeWindow();
	}

	@After
	
	public void tearDown(Scenario sc) {
		if (sc.isFailed()) {
			File screenShotSource = ((TakeScreenshot)Config.driver).getScreenshotAs(OutputType.FILE);
			File screenshotDestination = new File ("c:\\faileSc.png");
			
			try {
				FileUtils.copyFile(screenShotSource, screenshotDestination);
			}catch (IOException e) {
		}
	}
	}
