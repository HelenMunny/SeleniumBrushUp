package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FramesPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        Thread.sleep(3000);

        WebElement textBox = driver.findElement(By.id("name"));
        textBox.sendKeys("Hello");
        Thread.sleep(3000);

        driver.switchTo().frame(driver.findElement(By.id("frm1")));
        Thread.sleep(3000);
        Select select = new Select(driver.findElement(By.id("course")));
        select.selectByVisibleText("Java");
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);

        textBox.sendKeys(" World");
//        driver.quit();

    }
}
