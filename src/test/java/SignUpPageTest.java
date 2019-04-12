import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before//Before everyone test
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\root\\IdeaProjects\\PageObject\\drivers" +
                "\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void signUpWithShortPassword(){
        SignUpPage sp = signUpPage.typePassword("asf");
        String error = sp.getPasswordErrorText();
        Assert.assertEquals("Password is weak and can be easily guessed",error);
    }


}