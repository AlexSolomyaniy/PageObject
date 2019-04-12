import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("/html/body/div[4]/main/div/div/div[1]/h1");
    private By signUpButton = By.xpath("//*[@id=\"signup_button\"]");
    private By usernameField = By.xpath("//*[@id=\"user_login\"]");
    private By emailField = By.xpath("//*[@id=\"user_email\"]");
    private By passwordField = By.xpath("//*[@id=\"user_password\"]");
    private By mainErrorText = By.xpath("//*[@id=\"signup-form\"]/div[1]");
    private By errorEmptyUsername = By.xpath("//*[@id=\"signup-form\"]/auto-check[1]/dl/dd[2]");
    private By errorPassword = By.xpath("//*[@id=\"signup-form\"]/password-strength/dl/dd[2]");

    public SignUpPage typeUserName(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public SignUpPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String username,String email,String password){
        this.typeUserName(username);
        this.typePassword(password);
        this.typeEmail(email);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getPasswordErrorText(){
        return driver.findElement(errorPassword).getText();
    }

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getErrorEmptyUsername(){ return  driver.findElement(errorEmptyUsername).getText();}

    public String getMainErrorText(){
        return driver.findElement(mainErrorText).getText();
    }
}