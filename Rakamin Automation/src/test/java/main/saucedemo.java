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

    public static class LoginTest {
        @Test
        public void login() {
            WebDriver driver;
            String baseurl = "https://kasirdemo.belajarqa.com/";
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(baseurl);
            String tittle = driver.getTitle();
            System.out.println(tittle);
            driver.close();

        }

        @Test
        public void getTitle() {
            WebDriver driver;
            String baseurl = "https://kasirdemo.belajarqa.com/";
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(baseurl);
            String title = driver.getTitle();
            System.out.println(title);

            String usernameButton = "username";
            WebElement e1 = driver.findElement(By.id(usernameButton));
            e1.click();
            e1.sendKeys("email.com");
            e1.getText();

            WebElement e2 = driver.findElement(By.className("button"));
            e2.getText();

            driver.findElement(By.xpath("/*contains")).isDisplayed();

            driver.close();

        }
    }
}
