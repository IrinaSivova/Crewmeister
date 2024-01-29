package pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TimeTrackingOverview extends ParentPage {

    @FindBy (xpath = ".//button[@id='page-time-tracking-start-work']") private WebElement buttonStartWork;

    @FindBy (xpath = ".//span[@data-e2e-test = 'open-terminal']") private WebElement switchToTerminalButton;

    @FindBy (xpath = ".//button[@id = 'page-time-tracking-terminal-mode-three-column-terminal-with-no-authentication']") private WebElement terminalWithoutPasswordButton;

    @FindBy (xpath = ".//button[@data-e2e-test= 'page-time-tracking-switch-this-device-into-terminal-mode-modal']") private WebElement switchToTerminalConfirmButton;

    @FindBy (xpath = ".//button[@id= 'page-time-tracking-switch-this-device-into-terminal-mode-modal-confirm']") private WebElement buttonConfirmPassword;

   @FindBy (xpath = ".//a[@data-e2e-test = 'product-link-time-tracking-report']") private WebElement reportsMenu;
    public TimeTrackingOverview(WebDriver webDriver) {
        super(webDriver);
    }

    public TimeTrackingOverview checkRedirectToTimeTracking() {
        Assert.assertTrue("User is not logged in", isElementDisplayed(buttonStartWork));
        return this;
    }

    public CustomTerminal openTerminal() {
        scroll(switchToTerminalButton);
        clickElement(switchToTerminalButton);
        clickElement(terminalWithoutPasswordButton);
        clickElement(switchToTerminalConfirmButton);
        clickElement(buttonConfirmPassword);
        return new CustomTerminal(webDriver);
    }

    public Reports openReports() {
        clickElement(reportsMenu);
        return new Reports(webDriver);
    }
}
