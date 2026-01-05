package tests;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.PracticeFormPage;

@Epic("DemoQA")
@Feature("Practice Form")
public class FormTests {

    WebDriver driver;
    PracticeFormPage form;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        form = new PracticeFormPage(driver);
    }

    @Test
    @Story("Submit valid form")
    @Severity(SeverityLevel.CRITICAL)
    void submitFormTest() {
        form.open();
        form.enterFirstName("Nini");
        form.enterLastName("Qobelashvili");
        form.enterEmail("nini@gmail.com");
        form.selectGender();
        form.enterMobile("5555555555");
        form.setDateOfBirth();
        form.enterSubject("Maths");
        form.selectHobby();
        form.enterAddress("Tbilisi");
        form.selectStateAndCity();
        form.submitForm();

        Assert.assertEquals(form.getStudentName(), "Nini Qobelashvili");
        Assert.assertEquals(form.getEmailValue(), "nini@gmail.com");
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
