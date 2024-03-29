package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandling {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");

        WebElement search = driver.findElement(By.xpath("//input[@id=\"gh-btn\"]"));
        WebElement typeSearch = driver.findElement(By.xpath("//input[@id=\"gh-ac\"]"));
        typeSearch.sendKeys("Moisturizer");
        Thread.sleep(2000);
        search.click();

        //        copy text   ||   getText()
        String text = driver.findElement(By.xpath("//button[@id=\"gh-shop-a\"]")).getText();
        System.out.println(text);

//        handling dropdown
//        options for selecting: selectByVisibleText("string text"); selectByIndex(index number); selectByValue("string text");
        WebElement dropdown= driver.findElement(By.cssSelector("[id=\"gh-cat\"]"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Baby");
        Thread.sleep(2000);
        WebElement searchBtn = driver.findElement(By.xpath("//input[@id=\"gh-btn\"]"));
        searchBtn.click();
        driver.quit();


    }
}
