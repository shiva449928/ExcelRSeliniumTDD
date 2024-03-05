package com.ohrm.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;

public class OrangeHRMBase {
		
		public static WebDriver driver;
		public static Properties prop;
	
		public void initialization() {
			propertyFileConfiguration();
			String brwsr = prop.getProperty("browser");
			switch (brwsr) {
			case "chrome":
						driver = new ChromeDriver();
						break;
			case "firefox":	
						driver = new FirefoxDriver();
						break;
			case "ie":	
						driver = new InternetExplorerDriver();
						break;
			case "edge":	
						driver = new EdgeDriver();
						break;
			default:
					System.out.println("Enter the correct browser");
				break;
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("url"));
		}
		public void tearDown() {
			driver.quit();
		}
		public void propertyFileConfiguration() {
			String configFilepath = "./src/main/java/com/ohrm/config/config.properties";
			prop = new Properties();
			FileReader reader;
			try {
				reader = new FileReader(configFilepath);
				prop.load(reader);
			} catch (Exception e) {
				System.out.println("Unable to find the file");
			}
		}
		public void captureScreenshot(String name) throws IOException {
			String path = "./Screenshot/" +name+ ".png";
			TakesScreenshot ts = (TakesScreenshot)driver;
			File scrnshot = ts.getScreenshotAs(OutputType.FILE);
			Files.copy(scrnshot, new File(path));
		}
}
