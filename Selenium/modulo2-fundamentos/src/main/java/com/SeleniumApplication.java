package com;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumApplication {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/walter/Escritorio/chromedriver-linux64/chromedriver");
		//crear una instancia
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
			
		//Navegar a google
		driver.get("https://www.google.com");
		
		//localizar el elemento buscar
		WebElement searchBox = driver.findElement(By.name("q"));
		//Le damos buscar
		searchBox.sendKeys("Historia de Linux");
		//Le damos enter
		searchBox.submit();
//		driver.findElement(By.xpath("//*[@id=\"Sva75c\"]/div[2]/div[2]/div/div[2]/c-wiz/div/div[2]/div[1]/a/img")).click();
//		//Localizadores de los elementos
//		
//		//xpath
//		driver.findElement(By.xpath("//*[@id=\"searchbox\"]"));
//		
//		//selector css
//		driver.findElement(By.cssSelector("#searchbox"));
//		
//		//by id
//		driver.findElement(By.id("searchbox"));
//		
//		//by name
//		driver.findElement(By.name("q"));
//		
//		//by classname  (buscar el nombre de la clase)
//		driver.findElement(By.className(""));
//		
		
		try{
			driver.findElement(By.id("noExisteEsteId")).click();
		}
		catch(NoSuchElementException e) {
			System.out.println("El elemento no fue encontrado: " + e.getMessage());
		}
		catch(TimeoutException e) {
			System.out.println("Tiempo de espera agotado: " + e.getMessage());
		}
		finally {
			driver.quit();
		}
		
		//cerrar el navegador
		//driver.quit();
	}

}
