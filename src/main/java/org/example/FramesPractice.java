package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FramesPractice {
    public static void main(String[] args) throws InterruptedException {
//        nested iframe practice
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.findElement(By.xpath("//div[@class=\"tabpane\"]/ul/li[2]/a")).click();
        WebElement fr = driver.findElement(By.xpath("//div[@id=\"Multiple\"]/iframe"));
        driver.switchTo().frame(fr);
        System.out.println(driver.findElement(By.xpath("//div[@class=\"iframe-container\"]")).getText());
        WebElement nested = driver.findElement(By.xpath("//div[@class=\"container iframes-page-container\"]/div/iframe"));
        driver.switchTo().frame(nested);
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        inputs.get(0).sendKeys("Hello");
        driver.switchTo().defaultContent();
        System.out.println(driver.getTitle());
    }
}
