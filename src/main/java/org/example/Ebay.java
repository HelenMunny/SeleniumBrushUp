package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ebay {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mahmu\\IdeaProjects\\SeleniumBrushUp\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\mahmu\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");

        driver.findElement(By.xpath("//input[@id=\"gh-ac\"]")).sendKeys("Moisturizer");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"gh-btn\"]")).click();
    }
}
