package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ActionsPractice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mahmu\\IdeaProjects\\SeleniumBrushUp\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\mahmu\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");

//        Actions practice

//how many links are in ebay homepage
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

//        Actions class
        WebElement electronics = driver.findElement(By.xpath("//div[@id=\"vl-flyout-nav\"]/ul/li[4]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(electronics).perform();
        Thread.sleep(2000);
        WebElement videoGames = driver.findElement(By.xpath("//a[@_sp=\"p4375194.m1380.l3260\"]"));
        videoGames.click();


    }
}
