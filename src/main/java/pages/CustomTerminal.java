package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

public class CustomTerminal extends ParentPage{

    @FindBy (xpath = ".//h1[text ()= 'Clocked out']") private WebElement areaClockedOut;

    @FindBy (xpath = ".//div [@class='_163uw1b']//h1[text() = 'Clocked out']") private WebElement clockedOut;

    @FindBy (xpath = ".//div [@class='_163uw1b']//h1[text() = 'Clocked in']") private WebElement clockedIn;

    @FindBy (xpath = ".//div [@class='_163uw1b']//h1[text() = 'Break']") private WebElement areaBreak;

    @FindBy (xpath = ".//div[contains (text(), 'Jose Barron')]") private WebElement employee;

    @FindBy (xpath = ".//span[contains (text(), 'You're clocked in')]") private WebElement toastMessageClockedIn;

    @FindBy (xpath = ".//span[contains (text(), 'You're clocked out')]") private  WebElement toastMessageClockedOut;

    @FindBy (xpath = ".//span[contains (text(), 'You're on break')]") private WebElement toastMessageBreak;

    public CustomTerminal(WebDriver webDriver) {
        super(webDriver);
    }

    public CustomTerminal checkRedirectToTerminal() {
        Assert.assertTrue("Terminal is not opened",isElementDisplayed(areaClockedOut));
        webDriver.navigate().refresh();
        return this;
    }

    public CustomTerminal clockedIn() {
        webDriver.navigate().refresh();
        customDragAndDrop(employee,clockedIn);
        Assert.assertTrue("Employee is not clocked in", isElementDisplayed(toastMessageClockedIn));
        return this;
    }

    public CustomTerminal clockedOut() {
        webDriver.navigate().refresh();
        customDragAndDrop(employee,clockedOut);
        Assert.assertTrue("Employee is not clocked out", isElementDisplayed(toastMessageClockedOut));
        return this;
    }

    public  CustomTerminal moveToBreak() {
        webDriver.navigate().refresh();
        customDragAndDrop(employee,areaBreak);
        Assert.assertTrue("Employee is not on a break", isElementDisplayed(toastMessageBreak));
        return this;
    }
}
