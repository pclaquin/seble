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
    WebElement password = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div/div/form/div[3]/input"));
    WebElement login = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div/div/form/div[2]/input"));
    WebElement confirmButton = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div/div/form/div[4]/button"));
    login.sendKeys("pclaquin.extern@groupeseb.com");
    password.sendKeys("DCPPlatform");
    confirmButton.click();
    System.out.println(driver.getCurrentUrl());
    driver.get("https://bat.bo.groupe-seb.com/#/contents/search");
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Nouveau contenu")));
    WebElement search = driver.findElement(By.linkText("Rechercher"));
    search.click();
    
    WebElement projectChoice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("select")));
    Select select = new Select(driver.findElement(By.tagName("Select")));
    select.selectByVisibleText("Aspi Robot");
    WebElement project = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("option")));
    project.click();
    List<WebElement> results = driver.findElements(By.tagName("tr"));
    Iterator<WebElement> results_it = results.iterator();
    while(results_it.hasNext()) {
    	System.out.println(results_it.next().getText());
    }
    driver.quit();
  }
}
