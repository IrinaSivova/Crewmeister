package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParentPage extends CommonActionsWithElements{
    protected String base_url;


    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        base_url = "https://app.crewmeister.com/sign-in/";
    }

}

