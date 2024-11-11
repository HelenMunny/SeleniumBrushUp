package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class GreenKart {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

        addItems(driver);
        checkout(driver);


    }

    public static void addItems(WebDriver driver){
        String[] vegNames = {"Brocolli","Carrot","Tomato","Cucumber"};
        List<String> veggies = Arrays.asList(vegNames);

        List<WebElement> items = driver.findElements(By.xpath("//h4[@class=\"product-name\"]"));
        int count=0;

        for(int i=0; i< items.size();i++){
            String[] parts = items.get(i).getText().toString().split("-");
            String fname = parts[0].toString().trim();

            if(veggies.contains(fname)){
                driver.findElements(By.xpath("//div[@class=\"product\"] //button")).get(i).click();
                count++;
                if (count== veggies.size()){
                    break;
                }
            }
        }
    }

    public static void checkout(WebDriver driver) throws InterruptedException {
//        click on cart button
        driver.findElement(By.xpath("//a[@class=\"cart-icon\"] //img")).click();
        Thread.sleep(3000);
//        proceed to checkout
        driver.findElement(By.xpath("//div[@class=\"cart-preview active\"] //button")).click();
        Thread.sleep(3000);
//        add promo code
        driver.findElement(By.xpath("//div[@class=\"promoWrapper\"] //input")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//div[@class=\"promoWrapper\"] //button")).click();
        Thread.sleep(5000);
        String actual = driver.findElement(By.xpath("//span[@class=\"promoInfo\"]")).getText();
        String expected = "Code applied ..!";
        Assert.assertEquals(actual,expected);
        String discountPerc = driver.findElement(By.xpath("//span[@class=\"discountPerc\"]")).getText();
        Assert.assertTrue(!discountPerc.equals("0%"));
        checkDiscount(driver);
        System.out.println(discountPerc);
//        click place order button
        driver.findElement(By.xpath("//button[contains(text(),\"Place Order\")]")).click();
        Thread.sleep(3000);
        WebElement country = driver.findElement(By.xpath("//select"));
        Select select = new Select(country);
        select.selectByValue("Bangladesh");
        Thread.sleep(2000);
        checkbox(driver);



    }

    public static void checkDiscount(WebDriver driver){
        String tot = driver.findElement(By.xpath("//span[@class=\"totAmt\"]")).getText();
        int total = Integer.valueOf(tot);
        String discountedTot = driver.findElement(By.xpath("//span[@class=\"discountAmt\"]")).getText();
        int discounted = Integer.valueOf(discountedTot);
        if(total>discounted){
            System.out.println("discount applied");
        }else{
            System.out.println("No discount");
        }
    }


    public static void checkbox(WebDriver driver){
        WebElement checkbox = driver.findElement(By.xpath("//input[@class=\"chkAgree\"]"));
        WebElement proceedBtn = driver.findElement(By.xpath("//button"));
        WebElement error = driver.findElement(By.xpath("//span[@class=\"errorAlert\"]"));
        WebElement errorMsg = driver.findElement(By.xpath("//span[@class=\"errorAlert\"]/b"));
//    checkbox.click();
        if(!checkbox.isSelected()){
            proceedBtn.click();
            System.out.println(errorMsg.getText());
            checkbox.click();
            proceedBtn.click();
        }

    }

}
