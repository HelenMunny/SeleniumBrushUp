package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Twitter {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mahmu\\IdeaProjects\\SeleniumBrushUp\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\mahmu\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://twitter.com/");


        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-testid=\"loginButton\"]/div/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("HelenMunny");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();     // if there is no unique identifier available, we can narrow down our search through this method
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Amader1Gram");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),\"Log in\")]")).click();




//       login should be completed, if not confirmation code will be asked or failed login due to incorrect password/username
    }
}