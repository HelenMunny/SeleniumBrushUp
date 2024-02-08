package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWaits {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\mahmu\\IdeaProjects\\SeleniumBrushUp\\src\\main\\resources\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:\\Users\\mahmu\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        implicit wait: implicit wait is a global wait that will be applicable for the all elements of the file. The maximum wait time here is 10 seconds
//        if we are sure that no element will take more than 10 seconds to load, we should use implicit wait
//        but if we want to make the system wait until a specific condition is met/served, we should use explicit wait.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    //implicit wait
        driver.get("https://twitter.com/");

        driver.findElement(By.xpath("//a[@data-testid=\"loginButton\"]/div/span")).click();
        driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("HelenMunny");
        driver.findElement(By.xpath("//span[contains(text(), 'Next')]")).click();     // if there is no unique identifier available, we can narrow down our search through this method
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Amader1Gram");
        driver.findElement(By.xpath("//span[contains(text(),\"Log in\")]")).click();


    }
}
