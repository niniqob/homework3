package tests;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AlertsPage;

@Epic("Alerts")
@Feature("Prompt Alert")
public class AlertTests {

    WebDriver driver;
    AlertsPage alerts;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        alerts = new AlertsPage(driver);
    }

    @Test
    @Story("Send name to alert")
    @Severity(SeverityLevel.NORMAL)
    void alertTextboxTest() {

        alerts.open();
        alerts.openPromptAlert();
        alerts.typeNameAndAccept("Nini Qobelashvili");

        Assert.assertTrue(alerts.getResultText().contains("Nini Qobelashvili"));
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
