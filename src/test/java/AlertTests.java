import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.naming.Name;

public class AlertTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Alerts.html");
    }


    @Test
    public void testAlertWithTextbox() throws InterruptedException {
        driver.findElement(By.linkText("Alert with Textbox")).click();
        driver.findElement(By.xpath("//button[contains(text(),'prompt box')]")).click();

        Alert alert = driver.switchTo().alert();

        String Name1 = "Nini Qobelashvili";
        alert.sendKeys(Name1);
        alert.accept();


        String result = driver.findElement(By.id("demo1")).getText();
        Assert.assertTrue(result.contains(Name1), "Alert text not displayed correctly!");
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
