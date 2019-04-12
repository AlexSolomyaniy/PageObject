import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//*[@id=\"login_field\"]");
    private By passwordField = By.xpath("//*[@id=\"password\"]");
    private By signInButton = By.xpath("//*[@id=\"login\"]/form/div[3]/input[4]");
    private By heading = By.xpath("//*[@id=\"login\"]/form/div[1]/h1");
    private By errorRegister = By.xpath("//*[@id=\"js-flash-container\"]/div");
    private By createAcountLink = By.xpath("//*[@id=\"login\"]/p/a");

    public LoginPage typeUsername(String username){
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithInvalidCreds(String username,String password){
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText(){
        return  driver.findElement(heading).getText();
    }

    public String getErrorText(){
        return  driver.findElement(errorRegister).getText();
    }

    public SignUpPage createAcount(){
        driver.findElement(createAcountLink).click();
        return new SignUpPage(driver);
    }
}