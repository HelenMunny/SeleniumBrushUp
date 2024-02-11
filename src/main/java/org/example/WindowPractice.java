package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    //implicit wait
        driver.get("https://demoqa.com/browser-windows");

        WebElement btn = driver.findElement(By.xpath("//button[@id=\"tabButton\"]"));
        btn.click();

        String currTab = driver.getWindowHandle();
        Set <String> allTabs = driver.getWindowHandles();
        for(String i: allTabs){
            if(i != currTab){
                driver.switchTo().window(i);
            }
        }

        WebElement heading = driver.findElement(By.xpath("//h1[@id=\"sampleHeading\"]"));
        System.out.println(heading.getText());
        driver.quit();
    }
}
