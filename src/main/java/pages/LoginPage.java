package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//input[@type='text']")
    private WebElement loginInput;
    @FindBy(xpath = ".//input[@type='password']")
    private WebElement passwordInput;

    @FindBy (xpath = ".//button[@id='user-sign-in']") private WebElement buttonSignIn;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage openLoginPage() {
        try {
            webDriver.get(base_url);
            return this;
        } catch (Exception e) {
            Assert.fail("Site can not be opened");
            return null;
        }
    }

    public LoginPage inputLogin(String login) {
        enterTextIntoElement(loginInput, login);
        return this;
    }

    public LoginPage inputPassword(String password) {
        enterTextIntoElement(passwordInput, password);
        return this;
    }

    public TimeTrackingOverview login() {
        clickElement(buttonSignIn);
        return new TimeTrackingOverview(webDriver);
    }

}
