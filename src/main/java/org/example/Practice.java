package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Practice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");
        WebElement ifr = driver.findElement(By.xpath("//iframe[@id=\"singleframe\"]"));
        driver.switchTo().frame(ifr);
        driver.findElement(By.tagName("input")).sendKeys("Helen");
        driver.switchTo().defaultContent();
    }
}



