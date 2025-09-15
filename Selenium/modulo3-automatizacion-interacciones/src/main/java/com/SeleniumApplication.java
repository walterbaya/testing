package com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumApplication {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/walter/Escritorio/chromedriver-linux64/chromedriver");
		//crear una instancia
		WebDriver driver = new ChromeDriver();
			
		//Creamos un esperador
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Navegar a Wikipedia
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
		
        // click en lupa
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#p-search > a"))).click();

        // volver a localizar el input justo antes de usarlo (evita stale)
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(By.name("search"))
        )).sendKeys("Selenium");

        // click en el botón de búsqueda
        wait.until(ExpectedConditions.elementToBeClickable(By.id("searchButton"))).click();
		
		
		//cerrar el navegador
		//driver.quit();
	}

}
