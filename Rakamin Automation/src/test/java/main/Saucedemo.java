package main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class saucedemo {
@Test
    public void succes_login_case(){
        WebDriver driver;
        String baseurl = "https://saucedemo.com/";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseurl);

        driver.findElement(By.id("user-name")).sendKeys(auth.username);
        driver.findElement(By.id("password")).sendKeys(auth.password);
        driver.findElement(By.id("login-button")).click();

        WebElement judul = driver.findElement(By.className("app_logo"));
        Assert.assertEquals("Swag Labs", judul.getText());

        driver.quit();

}
@Test
    public void failed_login_case(){
        WebDriver driver;
        String baseurl = "https://saucedemo.com/";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseurl);

        driver.findElement(By.id("user-name")).sendKeys(auth.username);
        pause(2000);
        driver.findElement(By.id("password")).sendKeys("test");
        pause(2000);
        driver.findElement(By.id("login-button")).click();
        pause(2000);
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        String error = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(errorMessage, error);
        driver.quit();

    }
    public static void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
