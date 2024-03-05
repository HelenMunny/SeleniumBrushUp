package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Practice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");

        List<WebElement> links = driver.findElements(By.xpath("//footer[@id=\"glbfooter\"] //a [@class=\"thrd\"]"));
        for (WebElement item:links){
            System.out.println(item.getText());
        }


    }
}
