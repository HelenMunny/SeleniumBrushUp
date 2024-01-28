package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

public class FindElements {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\mahmu\\IdeaProjects\\SeleniumBrushUp\\src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\mahmu\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);
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
