import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before//Before everyone test
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\root\\IdeaProjects\\PageObject\\drivers" +
                "\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginWithEmptyCredsTest(){
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("","");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.",error);
    }

    @Test
    public void loginWithIncorrectCredsTest(){
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("asdf","dsafsdf");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.",error);
    }

    @Test
    public void createAccountPageTest(){
        SignUpPage newLoginPage = loginPage.createAcount();
        String heading = newLoginPage.getHeadingText();
        Assert.assertEquals("Join GitHub",heading);
    }
}