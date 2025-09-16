package com;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumApplication {

	/**
	 * public static void main(String[] args) {
	 * System.setProperty("webdriver.firefoxz.driver",
	 * "D:\\Users\\Walter\\Desktop\\geckodriver.exe"); //crear una instancia
	 * WebDriver driver = new FirefoxDriver();
	 * 
	 * //Navegar a Wikipedia
	 * driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
	 * 
	 * // volver a localizar el input justo antes de usarlo (evita stale) WebElement
	 * searchBox = driver.findElement(By.id("searchInput"));
	 * 
	 * searchBox.sendKeys("Selenium");
	 * 
	 * //Vamos a esperar luego de escribir el texto WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(10));
	 * 
	 * WebElement searchButton =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div[2]/div/div/div/div/form/div/button")));
	 * searchButton.click();
	 * 
	 * //Esto es presionar enter. searchBox.submit(); //cerrar el navegador
	 * //driver.quit(); }
	 */

	// Llenado de formularios rapido, automatizacion.
	/*
	 * public static void main(String[] args) {
	 * 
	 * System.setProperty("webdriver.firefoxz.driver",
	 * "D:\\Users\\Walter\\Desktop\\geckodriver.exe"); //crear una instancia
	 * WebDriver driver = new FirefoxDriver();
	 * 
	 * //Navegar a Wikipedia driver.get(
	 * "https://auth.wikimedia.org/eswiki/wiki/Especial:Crear_una_cuenta?useformat=desktop&usesul3=1&returnto=Wikipedia%3APortada&centralauthLoginToken=178b350d31cd5c56f103b4aa682bee51"
	 * );
	 * 
	 * WebElement username = driver.findElement(By.cssSelector("#wpName2"));
	 * username.sendKeys("Walter");
	 * 
	 * WebElement password = driver.findElement(By.cssSelector("#wpPassword2"));
	 * password.sendKeys("1234");
	 * 
	 * WebElement passwordConfirm = driver.findElement(By.cssSelector("#wpRetype"));
	 * passwordConfirm.sendKeys("1234");
	 * 
	 * WebElement mail = driver.findElement(By.cssSelector("#wpEmail"));
	 * mail.sendKeys("walter@gmail.com");
	 * 
	 * }
	 */

	//Manejo de ventanas emergentes alerts y popups
	/*
	public static void main(String[] args) {

		System.setProperty("webdriver.firefoxz.driver", "D:\\Users\\Walter\\Desktop\\geckodriver.exe");
		// crear una instancia
		WebDriver driver = new FirefoxDriver();

		// Navegar a Wikipedia
		driver.get("https://onecompiler.com/html/3xfmfsrwk");

		WebElement button = driver.findElement(By.cssSelector("div[class='MuiGrid-root MuiGrid-item mui-1wxaqej'] button[aria-label='ctrl + enter']"));
		button.click();
		
		//Espera hasta que el alert este presente.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	
	}
	*/
	
	//Automatizacion de ventanas y pestañas del navegador
	/*public static void main(String[] args) {

		System.setProperty("webdriver.firefoxz.driver", "D:\\Users\\Walter\\Desktop\\geckodriver.exe");
		// crear una instancia
		WebDriver driver = new FirefoxDriver();

		// Navegar a Facebook
		driver.get("https://www.facebook.com/");
		String original = driver.getWindowHandle();
		
		
		//Switchear a la nueva pestaña
		WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
		newTab.get("https://www.facebook.com/help/568137493302217");
		
		Set<String> todasLasTabs = driver.getWindowHandles();
		
		String otraTab = "";
		
		//Iteramos las tabs y cuando encontramos una diferente a la original guardamos el identificador
		for(String handle: todasLasTabs) {
			if(!handle.equals(original)) {
				otraTab = handle;
				break;
			}
		}
		
		//Esperamos unos segundos a que cargue la pestaña
		try {
			Thread.sleep(3000);
			driver.switchTo().window(original);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	*/
	
	//Iframes
	/*public static void main(String[] args) {

		System.setProperty("webdriver.firefoxz.driver", "D:\\Users\\Walter\\Desktop\\geckodriver.exe");
		// crear una instancia
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
		
		// Navegar al Iframe, tenemos un iframe adentro de otro.
		driver.switchTo().frame("iframeResult");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='W3Schools Free Online Web Tutorials']")));
		
		
		WebElement iframeElement = driver.findElement(By.cssSelector("div[id='subtopnav'] a[title='JavaScript Tutorial']"));
		
		iframeElement.click();

	}
	*/
	
	//Elemento Drag and Drop
	public static void main(String[] args) {

		System.setProperty("webdriver.firefoxz.driver", "D:\\Users\\Walter\\Desktop\\geckodriver.exe");
		// crear una instancia
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop2");
		
		// Navegar al Iframe, tenemos un iframe adentro de otro.
		
		driver.switchTo().frame("iframeResult");
		
		//Vamos a seleccionar los elementos
		
		WebElement img = driver.findElement(By.id("img1"));
		WebElement div = driver.findElement(By.id("div2"));
		
		//realizar la accion de arrastrar y soltar
		Actions actions = new Actions(driver);
		actions.dragAndDrop(img, div).perform();
		
	}
}
