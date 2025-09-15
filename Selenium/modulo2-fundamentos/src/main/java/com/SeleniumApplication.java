package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		
		//localizar el elemento buscar
		WebElement searchBox = driver.findElement(By.name("q"));
		//Le damos buscar
		searchBox.sendKeys("Historia de Linux");
		//Le damos enter
		searchBox.submit();
		
		//Localizadores de los elementos
		
		//xpath
		driver.findElement(By.xpath("//*[@id=\"searchbox\"]"));
		
		//selector css
		driver.findElement(By.cssSelector("#searchbox"));
		
		//by id
		driver.findElement(By.id("searchbox"));
		
		//by name
		driver.findElement(By.name("q"));
		
		//by classname  (buscar el nombre de la clase)
		driver.findElement(By.className(""));
		
		
		
		
		
		
		
		
		
		//cerrar el navegador
		//driver.quit();
	}

}
