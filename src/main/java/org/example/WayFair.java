package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WayFair {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.wayfair.com/furniture/pdp/george-oliver-275-wide-tufted-armchair-w009453364.html?piid=1785453199");

        WebElement heading = driver.findElement(By.xpath("//div[@data-enzyme-id=\"titleBlockOnInfoBlock\"]/header/h1"));
        System.out.println(heading.getText());
        driver.quit();

    }
}
