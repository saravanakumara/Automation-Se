package com.learningmind.learning;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumConcepts {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "path");
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(false);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		driver.get("https://www.saucedemo.com"); //waits until page load
		//driver.navigate().to(""); //Based on PageLoadStrategy.Normal, Eager, None
		WebElement ele = driver.findElement(By.id("id"));
		//SearchContext sc = ele.getShadowRoot(); //Selenium 4
		List<WebElement> webElements = driver.findElements(By.id(""));
		ele.clear();
		ele.sendKeys("Test");
		ele.click();
		driver.getPageSource();
		driver.getTitle();
		driver.getCurrentUrl();
		Select dropDown = new Select(ele);
		dropDown.selectByVisibleText("Test");
		dropDown.selectByValue("id-none"); //It is not normal value and it is an attribute of the <option> tag
		dropDown.selectByIndex(0); //Not used mostly it will break the test when changes in the dropdown list
		ele.getText();
		
		org.openqa.selenium.Dimension dime = driver.manage().window().getSize();
		dime.getWidth();
		dime.getHeight();
		
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(1024, 480));
		
		Point coordinates = driver.manage().window().getPosition();
		coordinates.getX();
		coordinates.getY();
		
		driver.manage().window().setPosition(new Point(0, 0));
		
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.manage().window().fullscreen();
		
		
		
		WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(10)); //preconfigured fluentwait
		//wdWait.until(ExpectedConditions.alertIsPresent());
		wdWait.until(ExpectedConditions.elementToBeSelected(By.id("")));
		
		//custom wait
		Wait<WebDriver> fwait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		fwait.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.id(""));
			}
			
		});
		
		Actions builder = new Actions(driver);
		builder.sendKeys("Test"); //Single action
		
		Action action = builder
				.moveToElement(driver.findElement(By.id("")))
				.click()
				.keyDown(Keys.SHIFT)
				.sendKeys("test")
				.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB)
				.keyUp(Keys.SHIFT)
				.build(); //Multiple action combined and performed as single action
		action.perform();
		
		Robot robotKey = new Robot();
		robotKey.keyPress(KeyEvent.VK_CONTROL);
		robotKey.keyRelease(KeyEvent.VK_CONTROL);
		
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		File des = new File("screenshot.png");
		try {
			Files.copy(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
