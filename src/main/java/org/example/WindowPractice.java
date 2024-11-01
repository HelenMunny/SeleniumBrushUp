package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowPractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    //implicit wait
        driver.get("https://demo.automationtesting.in/Windows.html");

        WebElement btn = driver.findElement(By.xpath("//div[@class=\"tabpane pullleft\"]/ul/li[1]"));
        btn.click();
        WebElement openTab = driver.findElement(By.xpath("//div[@id=\"Tabbed\"]/a/button"));
        openTab.click();

        String currTab = driver.getWindowHandle();
        allTabs(driver,currTab);
        System.out.println(driver.findElement(By.xpath("//p[@class=\"lead mb-0\"]")).getText());
        driver.close();
        driver.switchTo().window(currTab);
        WebElement winBtn= driver.findElement(By.xpath("//div[@class=\"tabpane pullleft\"]/ul/li[3]"));
        winBtn.click();
        WebElement mulWinClick = driver.findElement(By.xpath("//div[@id=\"Multiple\"]/button"));
        mulWinClick.click();
        allTabs(driver,currTab);

    }

    public static void allTabs(WebDriver driver, String currTab){
        Set<String> allTabs = driver.getWindowHandles();
        for(String i:allTabs){
            if(currTab != i){
                driver.switchTo().window(i);
                System.out.println(driver.getTitle());
            }
        }
    }
}
