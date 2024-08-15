package com.Selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class ThreadLocalDriver {

	private static WebDriver driver;
	private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return tldriver.get();
	}
	
	public static void setDriver(WebDriver webdriver) {
		tldriver.set(webdriver);
	}
	
	public static void removeDriver() {
		tldriver.remove();
	}
	
	public static void initDriver(String url) {
		ChromeOptions co = new ChromeOptions();
		co.setBrowserVersion("117");
		co.addArguments("--start-maximized");
		driver = new ChromeDriver(co);
		setDriver(driver);
		getDriver().navigate().to(url);
		System.out.println(getDriver().getCurrentUrl());
	}
	
	public static void quitDriver() {
		getDriver().close();
		removeDriver();
	}
	
	@Test
	@Parameters({"browserName","url"})
	// url  https://magento.softwaretestingboard.com/
	public void runTest(String browserName,String url) {
		System.out.println("Browser is : "+browserName);
		System.out.println("URL is : "+url);
		ThreadLocalDriver.initDriver(url);
		getDriver().findElement(By.xpath("(//a[contains(text(),'Sign In')])[1]")).click();
		getDriver().findElement(By.xpath("//*[@id='email']")).sendKeys("harshit.hk.kumar2@gmail.com");
		getDriver().findElement(By.xpath("//input[@name='login[password]']")).sendKeys("Star#2607");
		getDriver().findElement(By.xpath("//*[@id='send2'and @class='action login primary']")).click();
		ThreadLocalDriver.quitDriver();
	}
	
}
