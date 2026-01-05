package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage {

    WebDriver driver;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By genderFemale = By.xpath("//label[text()='Female']");
    By mobile = By.id("userNumber");
    By dateInput = By.id("dateOfBirthInput");
    By subjectInput = By.id("subjectsInput");
    By hobbyMusic = By.xpath("//label[text()='Music']");
    By address = By.id("currentAddress");
    By state = By.id("state");
    By city = By.id("city");
    By submit = By.id("submit");

    public void open() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

    public void enterFirstName(String text) {
        driver.findElement(firstName).sendKeys(text);
    }
    public void enterLastName(String text) {
        driver.findElement(lastName).sendKeys(text);
    }

    public void enterEmail(String text) {
        driver.findElement(email).sendKeys(text);
    }
    public void selectGender() {
        scrollAndClick(genderFemale);
    }
    public void enterMobile(String text) {
        driver.findElement(mobile).sendKeys(text);
    }

    public void setDateOfBirth() {
        driver.findElement(dateInput).click();
        new Select(driver.findElement(By.className("react-datepicker__month-select")))
                .selectByVisibleText("December");
        new Select(driver.findElement(By.className("react-datepicker__year-select")))
                .selectByVisibleText("2005");
        driver.findElement(By.xpath("//div[text()='29']")).click();
    }

    public void enterSubject(String subject) {
        WebElement input = driver.findElement(subjectInput);
        input.sendKeys(subject);
        input.sendKeys("\n");
    }
    public void selectHobby() {
        scrollAndClick(hobbyMusic);
    }

    public void enterAddress(String text) {
        scrollTo(address);
        driver.findElement(address).sendKeys(text);
    }

    public void selectStateAndCity() {
        scrollAndClick(state);
        driver.findElement(By.xpath("//div[text()='NCR']")).click();
        scrollAndClick(city);
        driver.findElement(By.xpath("//div[text()='Delhi']")).click();
    }

    public void submitForm() {
        scrollAndClick(submit);
    }

    public String getStudentName() {
        return driver.findElement(By.xpath("//td[text()='Student Name']/following-sibling::td")).getText();
    }

    public String getEmailValue() {
        return driver.findElement(By.xpath("//td[text()='Student Email']/following-sibling::td")).getText();
    }

    private void scrollAndClick(By locator) {
        WebElement el = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
        el.click();
    }

    private void scrollTo(By locator) {
        WebElement el = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
    }
}
