import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.lang.model.element.Element;

public class Login {
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
