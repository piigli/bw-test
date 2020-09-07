package com.bw.loginpage;

import com.bw.page.LoginPage;
import com.bw.util.PropertyLoader;
import com.bw.webdriver.DriverManager;
import com.bw.webdriver.DriverManagerFactory;
import com.bw.webdriver.DriverType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class LoginPageTest {

    private LoginPage loginpage;
    private DriverManager driverManager;
    private WebDriver driver;

    @Before
    public void testInit(){
        String applicationUrl = PropertyLoader.loadProperty("application.url");
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.navigate().to(applicationUrl);
        loginpage = PageFactory.initElements(driver, LoginPage.class);
    }

    @After
    public void afterMethod() {
        driverManager.quitDriver();
    }

    @Features("Login Page")
    @TestCaseId("1")
    @Test
    public void TestSuccessfulLogin() throws InterruptedException {
        String uName="admin";
        String pWord="12345";
        loginpage.login(uName, pWord);

        String assertLoginText = driver.findElement(By.className("success")).getText();

        Assert.assertEquals(
                assertLoginText,
                "WELCOME :)");
    }

    @Features("Login Page")
    @TestCaseId("2")
    @Test
    public void TestInvalidPasswordLogin() throws InterruptedException {
        String uName="admin";
        String pWord="123456";
        loginpage.login(uName, pWord);

        String assertLoginText = driver.findElement(By.className("error")).getText();

        Assert.assertEquals(
                assertLoginText,
                "ACCESS DENIED!");
    }

    @Features("Login Page")
    @TestCaseId("3")
    @Test
    public void TestInvalidUsernameLogin() throws InterruptedException {
        String uName="admin1";
        String pWord="12345";
        loginpage.login(uName, pWord);

        String assertLoginText = driver.findElement(By.className("error")).getText();

        Assert.assertEquals(
                assertLoginText,
                "ACCESS DENIED!");
    }

    @Features("Login Page")
    @TestCaseId("4")
    @Test
    public void TestEmptyUsernameAndPasswordLogin() throws InterruptedException {
        String uName=" ";
        String pWord=" ";
        loginpage.login(uName, pWord);

        String assertLoginText = driver.findElement(By.className("error")).getText();

        Assert.assertEquals(
                assertLoginText,
                "ACCESS DENIED!");
    }
}
