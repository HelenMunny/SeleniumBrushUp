package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class FindElements {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");

        List<WebElement> list = driver.findElements(By.xpath("//li[@class=\"gf-li\"]"));
//        iterating over list of webelement through for loop
//        for(int i=0; i< list.size();i++){
//            System.out.println(list.get(i).getText());
//        }

//        advanced for loop
        for(WebElement a:list){
            System.out.println(a.getText());
        }

//        isDisplayed(), isEnabled()
        for(WebElement a:list){
            System.out.println(a.isEnabled());
        }
    }
}
