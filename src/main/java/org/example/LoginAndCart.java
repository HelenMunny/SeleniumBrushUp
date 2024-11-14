package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LoginAndCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement full = driver.findElement(By.xpath("//p[@class=\"text-center text-white\"]"));
        String[] parts = full.getText().split("is ");
        String[] userParts = parts[1].toString().split(" ");
        String username = userParts[0];
        String[] passParts = parts[2].toString().split("\\)");
        String psw = passParts[0];
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(psw);
        driver.findElement(By.xpath("//input[@value=\"user\"]/following-sibling::span")).click();
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('okayBtn').click();");
        Thread.sleep(2000);
        WebElement dropdown = driver.findElement(By.xpath("//select[@class=\"form-control\"]"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Teacher");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"terms\"]")).click();
        driver.findElement(By.id("signInBtn")).click();
        Thread.sleep(3000);

//        add products to cart
        List<WebElement> addBtns = driver.findElements(By.xpath("//div[@class=\"card h-100\"] //button"));
        for(WebElement btn:addBtns){
            Thread.sleep(2000);
            btn.click();
        }
//       click checkout btn
        driver.findElement(By.xpath("//a[@class=\"nav-link btn btn-primary\"]")).click();
        driver.findElement(By.xpath("//button[@class=\"btn btn-success\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"country\"]")).sendKeys("Bangladesh");
        driver.findElement(By.xpath("//div[@class=\"suggestions\"]/ul/li/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class=\"checkbox checkbox-primary\"]/label")).click();
        driver.findElement(By.xpath("//input[@class=\"btn btn-success btn-lg\"]")).click();
        String successMsg = driver.findElement(By.xpath("//div[@class=\"alert alert-success alert-dismissible\"]")).getText();
//        System.out.println(successMsg);
        StringBuffer sb = new StringBuffer(successMsg);
        String msg = sb.delete(0,2).toString();
        System.out.println(msg);
        driver.findElement(By.xpath("//a[@class=\"close\"]")).click();
    }
}
