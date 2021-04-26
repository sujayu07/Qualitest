package com.SujayUmesh.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class productorder {
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        String URL="http://automationpractice.com/index.php";

        // Open URL and Maximize browser window
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        //Click on Sign in
        driver.findElement(By.linkText("Sign in")).click();
        //Login
        driver.findElement(By.id("email")).sendKeys("suj@yopmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Hello");
        driver.findElement(By.id("SubmitLogin")).click();

        //Click on T-shirt
        driver.findElement(By.linkText("T-SHIRTS")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,750)", "");

        //Click on add to cart
        Actions actions = new Actions(driver);
        WebElement product = driver.findElement(By.linkText("Faded Short Sleeve T-shirts"));
        actions.moveToElement(product).perform();

        driver.findElement(By.xpath("//span[text()='Add to cart']")).click();

        //Click on proceed
        driver.findElement(By.xpath("/html//div[@id='layer_cart']//a[@title='Proceed to checkout']/span")).click();
        //Checkout page Proceed
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();
        //Agree terms&Conditions
        driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")).click();

        //Click on Payby Check
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();
        //Confirm the order
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();

        //Get Text
        String ConfirmationText=driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();

        // Verify that Product is ordered
        if(ConfirmationText.contains("complete")) {
            System.out.println("Order Completed: Test Case Passed");
        }
        else {
            System.out.println("Order Not Successfull: Test Case Failed");
        }

    }
}
