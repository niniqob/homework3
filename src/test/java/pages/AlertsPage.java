package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    WebDriver driver;

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    By alertWithTextbox = By.linkText("Alert with Textbox");
    By promptButton = By.xpath("//button[contains(text(),'prompt box')]");

    public void open() {
        driver.get("https://demo.automationtesting.in/Alerts.html");
    }

    public void openPromptAlert() {
        driver.findElement(alertWithTextbox).click();
        driver.findElement(promptButton).click();
    }

    public void typeNameAndAccept(String name) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(name);
        alert.accept();
    }

    public String getResultText() {
        return driver.findElement(By.id("demo1")).getText();
    }
}
