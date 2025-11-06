import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormTests {
WebDriver driver;

    @BeforeMethod
    void setUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void fillAndCheck() throws InterruptedException {

        driver.get("https://demoqa.com/automation-practice-form");

        driver.findElement(By.id("firstName")).sendKeys("Nini");
        driver.findElement(By.id("lastName")).sendKeys("Kobelashvili");
        driver.findElement(By.id("userEmail")).sendKeys("Nini@gmail.com");

        WebElement gender = driver.findElement(By.xpath("//label[text()='Female']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", gender);
        gender.click();

        driver.findElement(By.id("userNumber")).sendKeys("5555555555");

        driver.findElement(By.id("dateOfBirthInput")).click();
        Select month = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        Select year = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        month.selectByVisibleText("December");
        year.selectByVisibleText("2005");
        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--029']")).click();

        WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
        subjectInput.sendKeys("Maths");
        subjectInput.sendKeys("\n");

        WebElement hobby = driver.findElement(By.xpath("//label[text()='Music']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hobby);
        hobby.click();

        WebElement address = driver.findElement(By.id("currentAddress"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", address);
        address.sendKeys("Tbilisi");

        WebElement state = driver.findElement(By.id("state"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", state);
        state.click();
        driver.findElement(By.xpath("//div[text()='NCR']")).click();

        WebElement city = driver.findElement(By.id("city"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", city);
        city.click();
        driver.findElement(By.xpath("//div[text()='Delhi']")).click();


        WebElement submit = driver.findElement(By.id("submit"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        submit.click();

        WebElement modal = driver.findElement(By.id("example-modal-sizes-title-lg"));
        Assert.assertTrue(modal.isDisplayed(), "Submission modal is not visible.");
        WebElement name = driver.findElement(By.xpath("//td[text()='Student Name']/following-sibling::td"));
        Assert.assertEquals(name.getText(), "Nini Kobelashvili");

        WebElement email = driver.findElement(By.xpath("//td[text()='Student Email']/following-sibling::td"));
        Assert.assertEquals(email.getText(), "Nini@gmail.com");

        WebElement genderr = driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td"));
        Assert.assertEquals(genderr.getText(), "Female");

        WebElement mobile = driver.findElement(By.xpath("//td[text()='Mobile']/following-sibling::td"));
        Assert.assertEquals(mobile.getText(), "5555555555");

        WebElement date = driver.findElement(By.xpath("//td[text()='Date of Birth']/following-sibling::td"));
        Assert.assertEquals(date.getText(), "29 December,2005");

        WebElement subject = driver.findElement(By.xpath("//td[text()='Subjects']/following-sibling::td"));
        Assert.assertEquals(subject.getText(), "Maths");

        WebElement hobbies = driver.findElement(By.xpath("//td[text()='Hobbies']/following-sibling::td"));
        Assert.assertEquals(hobbies.getText(), "Music");

        WebElement address1 = driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td"));
        Assert.assertEquals(address1.getText(), "Tbilisi");

        WebElement location = driver.findElement(By.xpath("//td[text()='State and City']/following-sibling::td"));
        Assert.assertEquals(location.getText(), "NCR Delhi");


    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }



}
