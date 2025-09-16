package com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumApplication {

	public static void main(String[] args) {
		System.setProperty("webdriver.firefoxz.driver", "D:\\Users\\Walter\\Desktop\\geckodriver.exe");
		//crear una instancia
		WebDriver driver = new FirefoxDriver();
			
		//Navegar a Wikipedia
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
		
        // volver a localizar el input justo antes de usarlo (evita stale)
        WebElement searchBox = driver.findElement(By.id("searchInput"));
		
        searchBox.sendKeys("Selenium");

		//Vamos a esperar luego de escribir el texto
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchButton =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div[2]/div/div/div/div/form/div/button")));
        searchButton.click();
       				
		//cerrar el navegador
		//driver.quit();
	}

}
