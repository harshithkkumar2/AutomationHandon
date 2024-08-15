package com.Selenium.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions co = new ChromeOptions();
		co.setBrowserVersion("117");
		WebDriver cdriver = new ChromeDriver(co);
		cdriver.get("https://www.google.co.in/");
		System.out.println(cdriver.getCurrentUrl());
		cdriver.close();

	}

}
