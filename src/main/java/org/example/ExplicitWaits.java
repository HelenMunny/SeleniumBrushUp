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

        WebElement serachBar = driver.findElement(By.cssSelector("[id=\"APjFqb\"]"));
        serachBar.sendKeys("selenium");
        serachBar.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-ved=\"2ahUKEwjygNmO7YmEAxVJi7AFHWm9BSsQFnoECCEQAQ\"]")));

        driver.findElement(By.xpath("//a[@data-ved=\"2ahUKEwjygNmO7YmEAxVJi7AFHWm9BSsQFnoECCEQAQ\"]")).click();
//        here this might take some time to display the results available for my search. We can use explicit wait here for a specific condition

    }
}
