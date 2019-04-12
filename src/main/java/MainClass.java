import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\root\\IdeaProjects\\PageObject\\drivers" +
                "\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://github.com");

        MainPage mainPage = new MainPage(driver);

        //mainPage.register("test","sadf","sf");
        //mainPage.clickSignUpFormButton();
        mainPage.typeEmail("dsf");

        if (mainPage.emailError() == null)
            System.out.println("Work");
        else
            System.out.println("Not work");

    }
}