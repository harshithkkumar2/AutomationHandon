package com.Selenium.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver cdriver = new ChromeDriver();
		cdriver.get("https://www.google.co.in/");
		System.out.println(cdriver.getCurrentUrl());
		cdriver.close();

	}

}
