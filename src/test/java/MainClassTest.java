import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClassTest {

    private WebDriver driver;
    private MainPage mainPage;
    /*@BeforeClass//Before test execution
    public void beforeClassMethod(){

    }*/

    @Before//Before everyone test
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\root\\IdeaProjects\\PageObject\\drivers" +
                "\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://github.com");
        mainPage = new MainPage(driver);
    }


    @After//After everyone test
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void signInTest(){
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub",heading);
    }

    @Test
    public void registerFailTest(){
        SignUpPage signUpPage = mainPage.register("sadf","sdaf","sadf");
        String error =  signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.",error);
    }

    @Test
    public void usernameEmptyTest(){
        SignUpPage signUpPage = mainPage.register("","alexscsa@gmail.com","sadf");
        String error =  signUpPage.getErrorEmptyUsername();
        Assert.assertEquals("Login can't be blank",error);
    }


/*
    @AfterClass//After Test execution
    public void afterClassMethod(){

    }*/
}