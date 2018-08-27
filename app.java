package seletest2;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class App {
 
   public static void main(String[] args) throws Exception {

	System.setProperty("webdriver.chrome.driver","C:\\Users\\pclaquin\\Documents\\eclipse\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
    driver.get("https://bat.bo.groupe-seb.com/#/login");

	   /*
	    ///Crowdin
	    driver.get("http:\\crowdin.com");
	    List<WebElement> elements = driver.findElements(By.xpath("//*[contains(text(), 'Log in')]"));
	    Iterator i = elements.iterator();
	    while(i.hasNext()) {
	    	((WebElement) i.next()).click();
	    }
	    
	    //In the login page
	    System.out.println(driver.getCurrentUrl());
	    
	    WebElement login = driver.findElement(By.id("login_login"));
	    WebElement password = driver.findElement(By.id("login_password"));
	    WebElement button = driver.findElement(By.tagName("button"));
	    System.out.println(button.getSize());
	    login.sendKeys("TODO");
	    password.sendKeys("TODO");
	    button.click();
	    
	    //In the project page
	    WebElement project1 = driver.findElement(By.id("project-259842"));
	    project1.click();
	    
	    //Searching for the right elements
	    List<WebElement> progressions = driver.findElements(By.className("translation-progress-holder"));
	    List<WebElement> countriesContainer = driver.findElements(By.className("language-inner-text"));
	    Iterator<WebElement> itProgressions = progressions.iterator();
	    Iterator<WebElement> itCountries = countriesContainer.iterator();
	    
	    //Print progressions
	    while(itProgressions.hasNext()) {
	    	System.out.println(itProgressions.next().getAttribute("data-original-title"));
	    }
	    while(itCountries.hasNext()) {
	    	System.out.println("Country");
	    	System.out.println(itCountries.next().getText());
	    }
	    
	    driver.navigate().back();
	    
	    WebElement project2 = driver.findElement(By.id("project-247047"));
	    project2.click();
	    
	    //Searching for the right elements
	    List<WebElement> progressions2 = driver.findElements(By.className("translation-progress-holder"));
	    List<WebElement> countriesContainer2 = driver.findElements(By.className("language-inner-text"));
	    Iterator<WebElement> itProgressions2 = progressions2.iterator();
	    Iterator<WebElement> itCountries2 = countriesContainer2.iterator();
	    
	    //Print progressions
	    while(itProgressions2.hasNext()) {
	    	System.out.println(itProgressions2.next().getAttribute("data-original-title"));
	    }
	    while(itCountries2.hasNext()) {
	    	System.out.println("Country");
	    	System.out.println(itCountries2.next().getText());
	    }
	    
	    */
	    
	    ////////////////////////
	    //Récupération DCP//
	    
	    
	    driver.get("https://preprod.bo.groupe-seb.com/#/login");
	    WebElement password = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div/div/form/div[3]/input"));
	    WebElement login = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div/div/form/div[2]/input"));
	    WebElement confirmButton = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div/div/form/div[4]/button"));
	    login.sendKeys("TODO");
	    password.sendKeys("TODO");
	    confirmButton.click();
	    System.out.println(driver.getCurrentUrl());
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement element3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Contenu")));
	    WebElement contenus = driver.findElement(By.xpath("//li[@ng-auth-resource='CONTENT']"));
	    contenus.click();
	   
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Rechercher")));
	    WebElement search = driver.findElement(By.linkText("Rechercher"));
	    search.click();
	    
	    WebElement element4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Brouillon")));
	    WebElement domaine = driver.findElement(By.xpath("//select[@name='domain']"));
	    domaine.click();
	    
	    WebElement element16 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("select")));
	    WebElement project = driver.findElement(By.xpath("//option[@label='Aspi Robot']"));
	    project.click();
	    
	    WebElement element5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Rechercher")));
	    WebElement marketChoice = driver.findElement(By.xpath("//select[@name='supertype']"));
	    marketChoice.click();
	    
	    WebElement element17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("select")));
	    WebElement contenu = driver.findElement(By.xpath("//option[@label='Contenu']"));
	    contenu.click();
	    
	    
	    
	   
	    List<WebElement> resultsProj = driver.findElements(By.xpath("//tr[@class='ng-scope']//td[4]"));
	    List<WebElement> resultsValid = driver.findElements(By.xpath("//tr[@class='ng-scope']//td[11]"));
	    Iterator<WebElement> resultsProj_it = resultsProj.iterator();
	    Iterator<WebElement> resultsValid_it = resultsValid.iterator();
	    while(resultsProj_it.hasNext()) {
	    	System.out.println(resultsProj_it.next().getText() + " | " + resultsValid_it.next().getText());
	    }
	    driver.quit();
	}

}

