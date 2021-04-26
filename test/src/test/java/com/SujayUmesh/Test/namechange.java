package com.SujayUmesh.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class namechange {
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
        //Click on personal information
        driver.findElement(By.xpath("//span[text()='My personal information']")).click();
        //Clear and change first name
        driver.findElement(By.id("firstname")).clear();
        driver.findElement(By.id("firstname")).sendKeys("Tommy");
        //clear and change last name
        driver.findElement(By.id("lastname")).clear();
        driver.findElement(By.id("lastname")).sendKeys("Umesh");
        //Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        //confirm password
        driver.findElement(By.id("old_passwd")).sendKeys("Hello");
        driver.findElement(By.id("passwd")).sendKeys("Hello");
        driver.findElement(By.id("confirmation")).sendKeys("Hello");
        driver.findElement(By.xpath("//span[text()='Save']")).click();
        //Get Text
        String SuccessText=driver.findElement(By.partialLinkText("updated")).getText();

        // Verify that name is changed successfully
        if(SuccessText.contains(" successfully updated.")) {
            System.out.println("Name changed: Test Case Passed");
        }
        else {
            System.out.println("Name change failed: Test Case Failed");
        }


    }
}

