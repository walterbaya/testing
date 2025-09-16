package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumApplication {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/walter/Escritorio/chromedriver-linux64/chromedriver");
		//crear una instancia
		WebDriver driver = new ChromeDriver();
		
		//Navegar a google
		driver.get("https://www.google.com");
		
		//cerrar el navegador
		//driver.quit();
	}

}
