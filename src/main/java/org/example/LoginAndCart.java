package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAndCart {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebElement full = driver.findElement(By.xpath("//p[@class=\"text-center text-white\"]"));
        String[] parts = full.getText().split("is ");
        String[] userParts = parts[1].toString().split(" ");
        String username = userParts[0];
        String[] passParts = parts[2].toString().split("\\)");
        String psw = passParts[0];
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(psw);
        driver.findElement(By.xpath("//input[@value=\"user\"]/following-sibling::span")).click();
//        driver.switchTo().frame(driver.findElement(By.xpath("//div[@id=\"myModal\"]")));
//        driver.findElement(By.xpath("//button[@id=\"okayBtn\"]")).click();
    }
}
