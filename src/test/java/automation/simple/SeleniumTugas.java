package automation.simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTugas {
    WebDriver driver;

    @Test
    public void login() {
        //open browser
        WebDriverManager.firefoxdriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://yopmail.com/");

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(1));

        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).sendKeys("automationtest");
        driver.findElement(By.xpath("//button[@class='md']")).click();

        driver.switchTo().frame("ifinbox");
        String txtExpected1 = driver.findElement(By.xpath("//div[@id='e_ZwZkZwVlZQVlZmZmZQNjZQplBGHkAD==']//span[@class='lmf']")).getText();
        String txtActual1 = "Comcast Business";
        Assert.assertEquals(txtActual1, txtExpected1);

        String txtExpected2 = driver.findElement(By.xpath("//div[@class='mctn']/div[3]//span[@class='lmf']")).getText();
        String txtActual2 = "Brick&Bolt";
        Assert.assertEquals(txtActual2, txtExpected2);

        /* kenapa gak bisa ada 2 frame ya?
        * Error nya seperti ini : org.openqa.selenium.NoSuchFrameException: No frame element found by name or id ifmail Build info: version: '4.9.0', revision: 'd7057100a6' System info: os.name: 'Windows 11', os.arch: 'amd64', os.version: '10.0', java.version: '11.0.20' Driver info: driver.version: unknown */
//        driver.switchTo().frame("ifmail");
//        String txtExpected3 = driver.findElement(By.xpath("//span[@class='ellipsis b']")).getText();
//        String txtActual3 = "Brick&Bolt <care@bricknbolt.com>";
//        Assert.assertEquals(txtActual3, txtExpected3);

    }
}
