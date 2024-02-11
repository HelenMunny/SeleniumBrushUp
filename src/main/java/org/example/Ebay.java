package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Ebay {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/itm/314847937645?epid=25061474930&hash=item494e66446d:g:7qAAAOSwmdFj8Byr&amdata=enc%3AAQAIAAAAsOjn4H3nXiuFAevsloS0XXNJVdESgM9PoRTIouwiTWyXDdr8nthpfI%2BR2ZaTgZdzUWXIm06QYRiY6oIacJIISF3yBMX0HVvKwrvQdyjU6AXHgRmUnbkj%2F77FbNWW4646HsxpTcDK1Q9oNOUmOJtYu1WOi%2FUKAhrPyaAOSDnUfEU5%2FSMk7tkDZ62aTsoOxufkyav9EWrUQtI0Cu7K1JVKV7Lg4Vegdfh8aWv6aZtwUrE0%7Ctkp%3ABlBMUKrDq_2yYw");

        List<WebElement> texts = driver.findElements(By.xpath("//span[@class=\"ux-textspans\"]"));
        for(WebElement item:texts){
            System.out.println(item.getText());
        }


    }
}
