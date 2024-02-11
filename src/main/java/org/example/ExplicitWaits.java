package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaits {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement seachBar = driver.findElement(By.cssSelector("[id=\"APjFqb\"]"));
        seachBar.sendKeys("selenium");
        seachBar.sendKeys(Keys.ENTER);

//        explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@jsname=\"UWckNb\"][position()=1]")));
        link.click();
//        here this might take some time to display the results available for my search. We can use explicit wait here for a specific condition
        driver.quit();
    }
}
